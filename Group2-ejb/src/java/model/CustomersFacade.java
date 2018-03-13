/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entities.Customers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

/**
 *
 * @author Khanh
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> implements CustomersFacadeLocal {
    @PersistenceContext(unitName = "Group2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
    
    @Override
     public Customers getByEmail(String email) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root c = cq.from(Customers.class);
        cq.select(c);
        cq.where(cb.equal(c.get("Email"), email)
        );
        Query q = getEntityManager().createQuery(cq);
        Customers cus;
        try {
            cus = (Customers) q.getSingleResult();
        } catch (Exception e) {
            cus = null;
        }
        return cus;
    }
}
