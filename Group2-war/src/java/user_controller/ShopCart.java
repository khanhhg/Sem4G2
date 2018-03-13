/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user_controller;

import entities.ProductCarts;
import entities.Products;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import model.ProductsFacadeLocal;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class ShopCart {
    @EJB
    private ProductsFacadeLocal productsFacade;

     private HashMap<Integer, ProductCarts> cart;
    public ShopCart() {
        cart = new HashMap<>();
    }
     public HashMap<Integer, ProductCarts> getCart() {
        HttpSession session = SessionManager.getSession();
        if (session.getAttribute("CART") != null) {
            cart = (HashMap<Integer, ProductCarts>) session.getAttribute("CART");
        } else {
            cart = new HashMap<>();
        }
        return cart;
    }
      public void setCart(HashMap<Integer, ProductCarts> cart) {
        HttpSession session = SessionManager.getSession();
        session.setAttribute("CART", cart);
    }

    public String addCart(Products product) {
        cart = getCart();
        if (cart.containsKey(product.getProductID())) {
            if (cart.get(product.getProductID()).quantity >= cart.get(product.getProductID()).getTotal()) {
                cart.get(product.getProductID()).quantity = cart.get(product.getProductID()).getTotal();
            } else {
                cart.get(product.getProductID()).quantity++;
            }
        } else {
            cart.put(product.getProductID(), new ProductCarts(product.getProductName(), product.getImage(), product.getProductID(), product.getPriceOut(), product.getQuantity()));
        }
        setCart(cart);
        return "shopCart";
    }

    public String updateCart(Map.Entry<Integer, ProductCarts> entry) {
        cart = getCart();
        Products product = productsFacade.find(entry.getKey());
        if (product == null) {
            cart.remove(entry.getKey());
            setCart(cart);
            return "";
        }

        if (entry.getValue().quantity <= 0) {
            cart.remove(entry.getKey());
        } else {
            if (product.getQuantity() < entry.getValue().quantity) {
                entry.getValue().quantity = product.getQuantity();
            }
            if (entry.getValue().quantity <= 0) {
                cart.remove(entry.getKey());
            } else {
                cart.put(entry.getKey(), entry.getValue());
            }
        }
        setCart(cart);
        return "shopCart";
    }

    public String removeCart(int id) {
        cart = getCart();
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
        setCart(cart);
        return "shopCart";
    }

    public int getCount() {
        cart = getCart();
        return cart.size();
    }

    public long getTotal() {
        int total = 0;
        cart = getCart();
        if (cart.size() > 0) {
            for (ProductCarts item : cart.values()) {
                total += item.quantity * item.getPrice();
            }
        }
        return total;
    }
}
