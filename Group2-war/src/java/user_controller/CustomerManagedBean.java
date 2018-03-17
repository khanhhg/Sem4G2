/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user_controller;

import entities.Customers;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import model.CustomersFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class CustomerManagedBean {
    @EJB
    private CustomersFacadeLocal customersFacade;

   private Customers customer;
   private String confirmpass;
    public CustomerManagedBean() {
         if (customer == null) {
            customer = new Customers();
        }
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
      public String login() {
        if (customersFacade.checkLogin(customer.getEmail(), customer.getPassword())) {
            HttpSession session = SessionManager.getSession();
            session.setAttribute("email", customer.getEmail());
            return "index";
        }
        SessionManager.getRequest().setAttribute("message", "Email or password is incorrect");
        return "";
    }
}
