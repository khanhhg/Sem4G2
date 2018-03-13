/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entities.Products;
import java.util.List;
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
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {
    @PersistenceContext(unitName = "Group2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    @Override
      public List<Products> findAllOrder() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root c = cq.from(Products.class);
        cq.select(c);
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(c.get("orderCount")));
        cq.where(cb.gt(c.get("quantity"), 0));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(8);
        return q.getResultList();
    }
    @Override
       public List<Products> findAllPro() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root c = cq.from(Products.class);
        cq.select(c);
        cq.orderBy(getEntityManager().getCriteriaBuilder().desc(c.get("productID")));
        cq.where(cb.gt(c.get("quantity"), 0));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(12);
        return q.getResultList();
    }
    @Override
       public List<Products> findRelated(int categoryID) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root c = cq.from(Products.class);
        cq.select(c);
        cq.where(cb.gt(c.get("quantity"), 0),
                cb.equal(c.get("categoryID").get("categoryID"), categoryID)
        );
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(8);
        return q.getResultList();
    }
}
