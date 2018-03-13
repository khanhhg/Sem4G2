package entities;

import entities.News;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, String> adminName;
    public static volatile SingularAttribute<Admin, String> role;
    public static volatile SingularAttribute<Admin, String> adminPhone;
    public static volatile CollectionAttribute<Admin, News> newsCollection;
    public static volatile SingularAttribute<Admin, Integer> adminID;
    public static volatile SingularAttribute<Admin, String> adminEmail;
    public static volatile SingularAttribute<Admin, Short> status;

}