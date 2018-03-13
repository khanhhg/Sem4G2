package entities;

import entities.Customers;
import entities.OrderDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> orderAddress;
    public static volatile SingularAttribute<Orders, Integer> orderID;
    public static volatile CollectionAttribute<Orders, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Orders, Customers> customerID;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, String> orderPhone;
    public static volatile SingularAttribute<Orders, String> orderName;
    public static volatile SingularAttribute<Orders, Short> status;

}