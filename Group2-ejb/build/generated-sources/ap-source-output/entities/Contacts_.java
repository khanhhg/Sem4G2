package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2018-03-11T09:24:39")
@StaticMetamodel(Contacts.class)
public class Contacts_ { 

    public static volatile SingularAttribute<Contacts, Integer> contactID;
    public static volatile SingularAttribute<Contacts, String> contactName;
    public static volatile SingularAttribute<Contacts, String> contactMail;
    public static volatile SingularAttribute<Contacts, String> contactDetails;
    public static volatile SingularAttribute<Contacts, Short> status;

}