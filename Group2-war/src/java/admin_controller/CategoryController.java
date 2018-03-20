/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin_controller;

import entities.Categories;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CategoriesFacadeLocal;
import user_controller.SessionManager;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class CategoryController {
    @EJB
    private CategoriesFacadeLocal categoriesFacade;

   private Categories category;
    public CategoryController() {
         if (category == null) {
            category = new Categories();
        }
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
     public String addCategory() {
        categoriesFacade.create(category);
        category = new Categories();
        SessionManager.getRequest().setAttribute("message", "Successful");
        SessionManager.getRequest().setAttribute("messageDetails", "Add new category successful");
        return "listCategory";
    }
     public List<Categories> getList() {
        return categoriesFacade.findAll();
    }
      public String details(int id) {
        category = categoriesFacade.find(id);
        return "categoryDetail";
    }
       public String updateCategory() {
        categoriesFacade.edit(category);
        category = new Categories();
        SessionManager.getRequest().setAttribute("message", "Successful");
        SessionManager.getRequest().setAttribute("messageDetails", "Update infomation successful");
        return "listCategory";
    }

    public String deleteCategory(Categories cate) {
       
        categoriesFacade.remove(cate);
        SessionManager.getRequest().setAttribute("message", "Successful");
        SessionManager.getRequest().setAttribute("messageDetails", "Delete category successful");
        return "listCategory";
    }
     public String preUpdate(int id) {
        category = categoriesFacade.find(id);
        SessionManager.getRequest().setAttribute("message", "Success");
        SessionManager.getRequest().setAttribute("messageDetails", "Add new category successful");
        
        return "editCategory";
    }
}
