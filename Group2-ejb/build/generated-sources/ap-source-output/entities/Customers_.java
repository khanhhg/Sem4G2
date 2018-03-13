package entities;

import entities.Comments;
import entities.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> customerID;
    public static volatile CollectionAttribute<Customers, Orders> ordersCollection;
    public static volatile CollectionAttribute<Customers, Comments> commentsCollection;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile SingularAttribute<Customers, String> customerName;
    public static volatile SingularAttribute<Customers, Short> status;

}