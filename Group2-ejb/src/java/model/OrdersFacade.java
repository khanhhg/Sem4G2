/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entities.Customers;
import entities.Orders;
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
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "Group2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }
    
    
   
    
     public Long orderCancel(){
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(a) FROM Orders a WHERE a.Status = -1");
        try {
            count = (Long) q.getSingleResult();
        } catch (Exception e) {
            count = 0;
        }
        return count;
    }
    
    public Long orderNewOrder(){
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(a) FROM Orders a WHERE a.Status = 0");
        try {
            count = (Long) q.getSingleResult();
        } catch (Exception e) {
            count = 0;
        }
        return count;
    }
    
    public Long orderProgress(){
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(a) FROM Orders a WHERE a.Status = 1");
        try {
            count = (Long) q.getSingleResult();
        } catch (Exception e) {
            count = 0;
        }
        return count;
    }
    
    public Long orderComplete(){
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(a) FROM Orders a WHERE a.Status = 2");
        try {
            count = (Long) q.getSingleResult();
        } catch (Exception e) {
            count = 0;
        }
        return count;
    }
}
