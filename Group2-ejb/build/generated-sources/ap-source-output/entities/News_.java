package entities;

import entities.Admin;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, String> newsContent;
    public static volatile SingularAttribute<News, Admin> adminID;
    public static volatile SingularAttribute<News, String> title;

}