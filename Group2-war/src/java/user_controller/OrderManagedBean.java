/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user_controller;

import entities.Customers;
import entities.OrderDetails;
import entities.Orders;
import entities.ProductCarts;
import entities.Products;
import java.util.Calendar;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import model.CustomersFacadeLocal;
import model.OrderDetailsFacadeLocal;
import model.OrdersFacadeLocal;

import model.ProductsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class OrderManagedBean {
    @EJB
    private ProductsFacadeLocal productsFacade;
    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;
    @EJB
    private CustomersFacadeLocal customersFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;

   private Orders order;
    private OrderDetails orderDetails;
    private Customers customer;
   String orderName;
   String orderAddress;
   String orderPhone;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }
    public OrderManagedBean() {
         if (order == null) {
            order = new Orders();
        }
        if (orderDetails == null) {
            orderDetails = new OrderDetails();
        }
        if(customer == null){
            customer = new Customers();
        }
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
     public String checkout(){
        customer = customersFacade.getByEmail(SessionManager.getSession().getAttribute("email").toString());
        order = new Orders();
        HttpSession session = SessionManager.getSession();
        
        ShopCart cart = new ShopCart();
        for (Map.Entry<Integer, ProductCarts> item : cart.getCart().entrySet()) {
            Products product = productsFacade.find(item.getKey());
           
            if(product.getQuantity() < item.getValue().getQuantity()){
                SessionManager.getRequest().setAttribute("messages", "The product you buy is not sufficient quantity. Please update your cart");
                return "";
            }
        }
        
        if(customer.getEmail()!= null){
            order.setOrderName(customer.getCustomerName());
            order.setOrderPhone(customer.getPhone());
            order.setOrderAddress(customer.getAddress());
            return "checkOut";
        }
        return "";
    }
       public String insertOrder() {
        
        HttpSession session = SessionManager.getSession();
         order.setOrderDate(Calendar.getInstance().getTime());

         order.setStatus(new Short("0"));
         order.setCustomerID(customersFacade.getByEmail(session.getAttribute("email").toString()));
        order.setOrderID(0);
        order.setCustomerID(customersFacade.getByEmail(session.getAttribute("email").toString()));
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setStatus(new Short("0"));
          ordersFacade.create(order);

        ShopCart cart = new ShopCart();
        for (Map.Entry<Integer, ProductCarts> item : cart.getCart().entrySet()) {
            Products product = productsFacade.find(item.getKey());
            if(product.getQuantity() < item.getValue().getQuantity()){
                SessionManager.getRequest().setAttribute("messages", "The product you buy is not sufficient quantity. Please update your cart");
                return "";
           }
            int quantity = product.getQuantity() - item.getValue().getQuantity();
            product.setQuantity(quantity);
            product.setOrderCount(product.getOrderCount() + 1);
            productsFacade.edit(product);
            orderDetails = new OrderDetails();
          
            orderDetails.setOrderID(order);
             
            orderDetails.setProductID(product);
            orderDetails.setQuantity((short) item.getValue().getQuantity());
            orderDetailsFacade.create(orderDetails);
        }
        session.removeAttribute("CART");
        order = new Orders();
        orderDetails = new OrderDetails();
      return "index";
    }

  
}
