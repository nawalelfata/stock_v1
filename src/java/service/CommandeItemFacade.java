/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CommandeItem;
import bean.Produit;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author princ
 */
@Stateless
public class CommandeItemFacade extends AbstractFacade<CommandeItem> {
    @PersistenceContext(unitName = "Stock_v1PU")
    private EntityManager em;
    
    @EJB
    CommandeItemFacade commandeItemFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeItemFacade() {
        super(CommandeItem.class);
    }
    
    public List<CommandeItem> findByCommande(String reference){
         return  em.createQuery("SELECT cm FROM CommandeItem cm where cm.commande.reference ='" +reference + "'").getResultList();
                
        
    }
    
    
    
}
