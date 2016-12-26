package com.firefly.product.facturacion.web;

import com.firefly.product.facturacion.negocio.entities.Detallefactura;
import com.firefly.product.facturacion.negocio.entities.Factura;
import com.firefly.product.facturacion.negocio.entities.Serviciosimpuestos;
import com.firefly.product.facturacion.negocio.session.FacturaFacade;
import com.firefly.product.facturacion.negocio.session.ResolucionfacturacionFacade;
import com.firefly.product.facturacion.negocio.session.ServiciosimpuestosFacade;
import com.firefly.product.facturacion.web.util.JsfUtil;
import com.firefly.product.facturacion.web.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.RowEditEvent;

@Named("facturaController")
@SessionScoped
public class FacturaController implements Serializable {

    @EJB
    private FacturaFacade ejbFacade;
    @EJB
    private ResolucionfacturacionFacade resolucionfacturacionFacade;
    @EJB
    private ServiciosimpuestosFacade serviciosimpuestosFacade;
    private List<Factura> items = null;
    private Factura selected;

    public FacturaController() {
    }

    public Factura getSelected() {
        return selected;
    }

    public void setSelected(Factura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FacturaFacade getFacade() {
        return ejbFacade;
    }

    public Factura prepareCreate() {
        selected = new Factura();
        initializeEmbeddableKey();
        return selected;
    }

    public void createDetalle() {
        if (selected != null) {
            if (selected.getDetallefacturaCollection() == null) {
                selected.setDetallefacturaCollection(new ArrayList<>());
            }
            Detallefactura detalle = new Detallefactura();
            detalle.setIdFactura(this.selected);
            detalle.setCantidad(0);
            detalle.setDescuento(0F);
            selected.getDetallefacturaCollection().add(detalle);
        }
    }

    public void updateDetalleValueChangeListener() {

        this.updateDetailAndTotalValues();

    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FacturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FacturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void updateDetailAndTotalValues() {

        float impuesto = 0;
        float total = 0;

        if (this.selected != null && this.selected.getDetallefacturaCollection() != null) {
            for (Detallefactura item : this.selected.getDetallefacturaCollection()) {

                if (item.getIdservicio() != null) {
                    item.setPrecioUnitario(item.getIdservicio().getPrecioVenta());
                    if (item.getDescuento() != null && item.getDescuento() != 0) {
                        item.setTotal((item.getPrecioUnitario() * (100 - item.getDescuento()) / 100) * item.getCantidad());
                    } else {
                        item.setTotal(item.getPrecioUnitario() * item.getCantidad());
                    }

                    Serviciosimpuestos serviciosimpuestos = new Serviciosimpuestos();
                    serviciosimpuestos.setIdservicios(item.getIdservicio());

                    List<Serviciosimpuestos> serviciosimpuestosList = serviciosimpuestosFacade.findAllImpuestosServicio(serviciosimpuestos);

                    int impuestoTotal = 0;

                    if (serviciosimpuestosList != null) {
                        for (Serviciosimpuestos serviciosimpuestos1 : serviciosimpuestosList) {
                            impuestoTotal += serviciosimpuestos1.getIdimpuestos().getPorcentaje();
                        }
                    }

                    item.setTotalImpuesto(item.getTotal() * (100 + impuestoTotal) / 100); 
                    total += item.getTotal();
                    impuesto += item.getTotalImpuesto();
                }

            }
        }

        this.selected.setSubTotal(total);
        this.selected.setImpuesto(impuesto - total);
        this.selected.setTotal(impuesto);
    }

    public void onDetalleFacturaEdit(RowEditEvent event) {

        this.updateDetailAndTotalValues();

    }

    public List<Factura> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                    selected.setConsecutivo(selected.getIdresolucion().getPrefijo() + selected.getIdresolucion().getSecuencia());
                    selected.setEstado(1);
                    selected.getIdresolucion().setSecuencia(selected.getIdresolucion().getSecuencia() + 1);
                    resolucionfacturacionFacade.edit(selected.getIdresolucion());
                }
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Factura getFactura(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Factura> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Factura> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Factura.class)
    public static class FacturaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturaController controller = (FacturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturaController");
            return controller.getFactura(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Factura) {
                Factura o = (Factura) object;
                return getStringKey(o.getIdfactura());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Factura.class.getName()});
                return null;
            }
        }

    }

}
