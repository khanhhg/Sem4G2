/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user_controller;

import entities.Brands;
import entities.Products;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.BrandsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class BrandManagedBean {
    @EJB
    private BrandsFacadeLocal brandsFacade;

    private Brands brands;
    private List<Products> listProduct;
    public BrandManagedBean() {
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public List<Products> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Products> listProduct) {
        this.listProduct = listProduct;
    }
    // Phuong thuc
     public List<Brands> getList() {
        return brandsFacade.findAll();
    }
     public String showBrand() {
        int id;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            id = Integer.parseInt(params.get("brandID"));
        } catch (NumberFormatException e) {
            return "404";
        }
        
        if (id <= 0) {
            return "index";
        } else {
            brands = brandsFacade.find(id);
            return "itemInBrand";
        }
    }
}
