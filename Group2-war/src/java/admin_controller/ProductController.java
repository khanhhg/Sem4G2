/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_controller;

import entities.Products;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.ProductsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class ProductController {

    @EJB
    private ProductsFacadeLocal productsFacade;
    private Products product;

    public ProductController() {

    }

    public String details(int id) {
        product = productsFacade.find(id);
        return "ChiTietSanPham";
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
