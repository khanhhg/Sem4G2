package entities;

import entities.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Brands.class)
public class Brands_ { 

    public static volatile SingularAttribute<Brands, String> brandName;
    public static volatile CollectionAttribute<Brands, Products> productsCollection;
    public static volatile SingularAttribute<Brands, Integer> brandID;
    public static volatile SingularAttribute<Brands, Short> status;

}