/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user_controller;

import entities.Comments;
import entities.Customers;
import entities.Products;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CommentsFacadeLocal;
import model.CustomersFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class CommentManagedBean {
    @EJB
    private CommentsFacadeLocal commentsFacade;
    @EJB
    private CustomersFacadeLocal customersFacade;

    private Comments comment;
    public CommentManagedBean() {
         if (comment == null) {
            comment = new Comments();
        }
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }
    /*
     public String addComment(String customerName, Products productID) {
        Customers customerID = customersFacade.getByEmail(customerName);
        comment.setCustomerID(customerID);
        comment.setProductID(productID);
        commentsFacade.create(comment);
        comment = null;
        return "";
    }
*/
     public String addComment( Products productID) {
       
       
        comment.setProductID(productID);
        commentsFacade.create(comment);
        comment = null;
        return "";
    }
    public List<Comments> getList(int id) {
        return commentsFacade.findOnProduct(id);
    }
}
