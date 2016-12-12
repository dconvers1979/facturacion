package com.firefly.product.facturacion.web;

import com.firefly.product.facturacion.negocio.entities.Sucursalesservicios;
import com.firefly.product.facturacion.negocio.session.SucursalesserviciosFacade;
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

@Named("sucursalesserviciosController")
@SessionScoped
public class SucursalesserviciosController implements Serializable {

    @EJB
    private SucursalesserviciosFacade ejbFacade;
    private List<Sucursalesservicios> items = null;
    private Sucursalesservicios selected;

    public SucursalesserviciosController() {
    }

    public Sucursalesservicios getSelected() {
        return selected;
    }

    public void setSelected(Sucursalesservicios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SucursalesserviciosFacade getFacade() {
        return ejbFacade;
    }

    public Sucursalesservicios prepareCreate() {
        selected = new Sucursalesservicios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SucursalesserviciosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SucursalesserviciosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SucursalesserviciosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Sucursalesservicios> getItems() {
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

    public Sucursalesservicios getSucursalesservicios(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Sucursalesservicios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Sucursalesservicios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Sucursalesservicios.class)
    public static class SucursalesserviciosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SucursalesserviciosController controller = (SucursalesserviciosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sucursalesserviciosController");
            return controller.getSucursalesservicios(getKey(value));
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
            if (object instanceof Sucursalesservicios) {
                Sucursalesservicios o = (Sucursalesservicios) object;
                return getStringKey(o.getIdsucursalesServicios());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Sucursalesservicios.class.getName()});
                return null;
            }
        }

    }

}
