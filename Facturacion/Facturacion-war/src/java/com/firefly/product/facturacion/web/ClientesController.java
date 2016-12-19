package com.firefly.product.facturacion.web;

import com.firefly.product.facturacion.negocio.entities.Clientes;
import com.firefly.product.facturacion.negocio.session.ClientesFacade;
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
import javax.faces.event.ValueChangeEvent;

@Named("clientesController")
@SessionScoped
public class ClientesController implements Serializable {

    @EJB
    private ClientesFacade ejbFacade;
    private List<Clientes> items = null;
    private Clientes selected;
    private boolean naturalPerson = false;

    public ClientesController() {
    }

    public Clientes getSelected() {
        return selected;
    }

    public void setSelected(Clientes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ClientesFacade getFacade() {
        return ejbFacade;
    }

    public Clientes prepareCreate() {
        selected = new Clientes();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClientesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClientesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClientesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Clientes> getItems() {
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

    public Clientes getClientes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Clientes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Clientes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    public List<Clientes> getItemsAvailableSelectOnePersons() {
        return getFacade().findAllPersons();
    }

    public void documentoValueChangeListener(ValueChangeEvent e) {
        
        selected.setPrimerNombre(null);
        selected.setSegundoNombre(null);
        selected.setPrimerApellido(null);
        selected.setSegundoApellido(null);
        selected.setDigitoVerificacion(null);
        selected.setFechaNacimiento(null);
        selected.setIdrepresentantelegal(null);
        selected.setRazonSocial(null);

        if (selected.getTipoDocumento() != 0) {
            if (selected.getTipoDocumento() == 1) {
                //persona natural

                setNaturalPerson(true);

            } else if (selected.getTipoDocumento() == 2) {
                //persona juridica
                setNaturalPerson(false);

            }
        }

    }

    /**
     * @return the naturalPerson
     */
    public boolean isNaturalPerson() {
        return naturalPerson;
    }

    /**
     * @param naturalPerson the naturalPerson to set
     */
    public void setNaturalPerson(boolean naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    @FacesConverter(forClass = Clientes.class)
    public static class ClientesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClientesController controller = (ClientesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clientesController");
            return controller.getClientes(getKey(value));
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
            if (object instanceof Clientes) {
                Clientes o = (Clientes) object;
                return getStringKey(o.getIdclientes());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Clientes.class.getName()});
                return null;
            }
        }

    }
    
    

}
