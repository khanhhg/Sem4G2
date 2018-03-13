package entities;

import entities.Brands;
import entities.Categories;
import entities.Comments;
import entities.OrderDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> image;
    public static volatile SingularAttribute<Products, Integer> quantity;
    public static volatile SingularAttribute<Products, Integer> productID;
    public static volatile SingularAttribute<Products, String> productDetail;
    public static volatile CollectionAttribute<Products, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Products, Integer> orderCount;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, Long> priceIn;
    public static volatile SingularAttribute<Products, Brands> brandID;
    public static volatile CollectionAttribute<Products, Comments> commentsCollection;
    public static volatile SingularAttribute<Products, Long> priceOut;
    public static volatile SingularAttribute<Products, Categories> categoryID;
    public static volatile SingularAttribute<Products, Short> status;

}