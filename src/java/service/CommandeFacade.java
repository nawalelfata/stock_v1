/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Commande;
import bean.CommandeItem;
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
public class CommandeFacade extends AbstractFacade<Commande> {
    @PersistenceContext(unitName = "Stock_v1PU")
    private EntityManager em;
    
    @EJB
    CommandeFacade commandeFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CommandeFacade() {
        super(Commande.class);
    }
    
    public int saveCommande(Commande commande){
        
        int res=0;
        if(commande.getEtat()==1 && commande.getTotalRestant()==0){
            commande.setEtat(1);
            return -1;
            
        }
        else
            if(commande.getEtat()==1 && commande.getTotalRestant()!=0){
            commande.setEtat(1);    
                
            
            commandeFacade.edit(commande);
            create(commande);
            
            }
         
        return res;
         }
    
    
    
     
    
   
    
    
    
}
