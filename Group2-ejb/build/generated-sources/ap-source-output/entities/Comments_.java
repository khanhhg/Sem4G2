package entities;

import entities.Customers;
import entities.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Products> productID;
    public static volatile SingularAttribute<Comments, Customers> customerID;
    public static volatile SingularAttribute<Comments, Integer> commentID;
    public static volatile SingularAttribute<Comments, String> commentDetail;
    public static volatile SingularAttribute<Comments, Short> status;

}