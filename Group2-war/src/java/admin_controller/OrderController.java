/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin_controller;

import entities.OrderDetails;
import entities.Orders;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.OrderDetailsFacadeLocal;
import model.OrdersFacadeLocal;
import model.ProductsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class OrderController {
    @EJB
    private ProductsFacadeLocal productsFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

  private Orders order;
    public OrderController() {
         if (order == null) {
            order = new Orders();
        }
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
     public List<Orders> getList() {
        return ordersFacade.findAll();
    }
      public String viewDetails(int id) {
        order = ordersFacade.find(id);
        return "listOrderDetail";
    }
       public String changeStatus(int id, String status) {
        Orders or = ordersFacade.find(id);
        int quantity;
        if (or != null) {
            if (status.equals("-1")) {
                for (OrderDetails item : or.getOrderDetailsCollection()) {
                    quantity = item.getProductID().getQuantity() + item.getQuantity();
                    item.getProductID().setQuantity((short) quantity);
                    productsFacade.edit(item.getProductID());
                }
            }
            or.setStatus(new Short(status));
            ordersFacade.edit(or);
            order = ordersFacade.find(id);
        }
        return "";
    }
       public String remove(Orders order) {
          
//        int quantity;
//        for (OrderDetails item : order.getOrderDetailsCollection()) {
//            quantity = item.getProductID().getQuantity() + item.getQuantity();
//            item.getProductID().setQuantity((short) quantity);
//            productsFacade.edit(item.getProductID());
//        }
//        ordersFacade.remove(order);
      int i =  order.getStatus();
      if(i ==2){
       ordersFacade.remove(order);
       return "";
      }
      else{
           int quantity;
        for (OrderDetails item : order.getOrderDetailsCollection()) {
            quantity = item.getProductID().getQuantity() + item.getQuantity();
            item.getProductID().setQuantity((short) quantity);
            productsFacade.edit(item.getProductID());
        }
        ordersFacade.remove(order);
        return "";
      }
    }
   
}
