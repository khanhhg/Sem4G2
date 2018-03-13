/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_controller;

import entities.Categories;
import entities.Products;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.CategoriesFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class CategoryManagedBean {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    private List<Products> items = null;
    private int categoryID = 0;
    private Categories category;

    public CategoryManagedBean() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
// tao phuong thuc

    public List<Categories> getList() {
        return categoriesFacade.findAll();
    }

    public String showCategory() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id;
        try {
            id = Integer.parseInt(params.get("categoryID"));
        } catch (NumberFormatException e) {
            return "404";
        }
        if (id <= 0) {
            return "index";
        } else {

            this.category = categoriesFacade.find(id);
            return "itemInCategory";
        }
    }
}
