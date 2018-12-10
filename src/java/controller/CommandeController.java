package controller;

import bean.Commande;
import bean.CommandeItem;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.CommandeFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "commandeController")
@SessionScoped
public class CommandeController implements Serializable {

    @EJB
    private service.CommandeItemFacade commandeItemFacade;
    
    @EJB
    private service.CommandeFacade commandeFacade;
    private List<CommandeItem> items = null;
    private Commande selected;

    public CommandeController() {
    }
        
    private void initparam(){
        selected = new Commande();    
    }
    
    public void findByCommande(String reference)
    {
        items = (commandeItemFacade.findByCommande(reference));
        //setItems(commandeItemFacade.findByCommande(id));
    }
    
    public Commande getSelected() {
        if(selected == null){
            selected = new Commande();
        }
        return selected;
    }
    
    public String create(){
        
        commandeFacade.create(selected);
        return null;
    }

    //public void findByCommande
    
    public void setSelected(Commande selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CommandeFacade getFacade() {
        return commandeFacade;
    }

    public Commande prepareCreate() {
        selected = new Commande();
        initializeEmbeddableKey();
        return selected;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CommandeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CommandeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CommandeItem> getCommandeItems() {
        if (items == null) {
            items = new ArrayList();
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

    public List<Commande> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Commande> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Commande.class)
    public static class CommandeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CommandeController controller = (CommandeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "commandeController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Commande) {
                Commande o = (Commande) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Commande.class.getName()});
                return null;
            }
        }

    }

}
