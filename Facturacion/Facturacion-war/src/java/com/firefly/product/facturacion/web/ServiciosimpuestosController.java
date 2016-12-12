package com.firefly.product.facturacion.web;

import com.firefly.product.facturacion.negocio.entities.Serviciosimpuestos;
import com.firefly.product.facturacion.negocio.session.ServiciosimpuestosFacade;
import com.firefly.product.facturacion.web.util.JsfUtil;
import com.firefly.product.facturacion.web.util.JsfUtil.PersistAction;

import java.io.Serializable;
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

@Named("serviciosimpuestosController")
@SessionScoped
public class ServiciosimpuestosController implements Serializable {

    @EJB
    private ServiciosimpuestosFacade ejbFacade;
    private List<Serviciosimpuestos> items = null;
    private Serviciosimpuestos selected;

    public ServiciosimpuestosController() {
    }

    public Serviciosimpuestos getSelected() {
        return selected;
    }

    public void setSelected(Serviciosimpuestos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServiciosimpuestosFacade getFacade() {
        return ejbFacade;
    }

    public Serviciosimpuestos prepareCreate() {
        selected = new Serviciosimpuestos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosimpuestosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServiciosimpuestosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServiciosimpuestosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Serviciosimpuestos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
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

    public Serviciosimpuestos getServiciosimpuestos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Serviciosimpuestos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Serviciosimpuestos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Serviciosimpuestos.class)
    public static class ServiciosimpuestosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiciosimpuestosController controller = (ServiciosimpuestosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviciosimpuestosController");
            return controller.getServiciosimpuestos(getKey(value));
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
            if (object instanceof Serviciosimpuestos) {
                Serviciosimpuestos o = (Serviciosimpuestos) object;
                return getStringKey(o.getIdserviciosImpuestos());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Serviciosimpuestos.class.getName()});
                return null;
            }
        }

    }

}
