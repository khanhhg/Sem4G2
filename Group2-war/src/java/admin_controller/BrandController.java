/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin_controller;

import entities.Brands;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.BrandsFacadeLocal;
import user_controller.SessionManager;


/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class BrandController {
    @EJB
    private BrandsFacadeLocal brandsFacade;

   private Brands brand;
    public BrandController() {
        if(brand == null){
            brand = new Brands();
        }
    }

    public Brands getBrand() {
        return brand;
    }
     public List<Brands> getList(){
        return brandsFacade.findAll();
    }

    public String addBrand() {
        brandsFacade.create(brand);
        return "listBrand";
    }
    
    public String preUpdate(int id){
        brand = brandsFacade.find(id);
        SessionManager.getRequest().setAttribute("message", "Success");
        SessionManager.getRequest().setAttribute("messageDetails", "Add new brands successful");
        return "editBrand";
    }

    
    public String updateBrand() {
        brandsFacade.edit(brand);
        SessionManager.getRequest().setAttribute("message", "Success");
        SessionManager.getRequest().setAttribute("messageDetails", "Edit brands successful");
        return "listBrand";
    }
    
    public String deleteBrand(Brands brand){
        brandsFacade.remove(brand);
        SessionManager.getRequest().setAttribute("message", "Success");
        SessionManager.getRequest().setAttribute("messageDetails", "Delete brand successful");
        return "listBrand";
    }
    
    public String details(int id){
        brand = brandsFacade.find(id);
        return "brandDetail";
    }
    
}
