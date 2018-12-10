/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classification;
import bean.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author princ
 */
@Stateless
public class ClassificationFacade extends AbstractFacade<Classification> {
    @PersistenceContext(unitName = "Stock_v1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassificationFacade() {
        super(Classification.class);
    }
    
    public Classification getClassification(Long id){
        return em.find(Classification.class, id); 
    }
    
    public Long ajouterClassification(Classification c){
        em.persist(c);
        return c.getId();
    }
    //
    public List<Produit> findByProduit(Classification classification){
         return  em.createQuery("SELECT pr FROM Produit pr where pr.classification.id ='" +classification.getId() + "'").getResultList();
                 
    } 
    public Long ajouterProduit(Produit p, Long id){
        
        Classification cl = getClassification(id);
        p.setClassification(cl);
        em.persist(p);
        return p.getIdProduit();
    }   
    
    
}
