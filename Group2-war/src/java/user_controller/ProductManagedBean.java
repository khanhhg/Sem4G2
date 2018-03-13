/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_controller;

import entities.Products;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.ProductsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class ProductManagedBean {

    @EJB
    private ProductsFacadeLocal productsFacade;

    private int productID;
    private Products product;

    public ProductManagedBean() {
        if (product == null) {
            product = new Products();
        }
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    /* Tao phuong thuc */
    public List<Products> getNewList() {
        return productsFacade.findAllPro();
    }

    public List<Products> getOrderList() {
        return productsFacade.findAllOrder();
    }
  public List<Products> getRelatedList(String categoryID){
        return productsFacade.findRelated(Integer.parseInt(categoryID));
    }
    public String showProduct() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(params.get("productID"));
        if (id <= 0) {
            return "index";
        } else {
            this.productID = id;
            this.product = productsFacade.find(id);
            return "viewProduct";
        }
    }

}
