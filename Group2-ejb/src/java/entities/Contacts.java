/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "Contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c"),
    @NamedQuery(name = "Contacts.findByContactID", query = "SELECT c FROM Contacts c WHERE c.contactID = :contactID"),
    @NamedQuery(name = "Contacts.findByContactName", query = "SELECT c FROM Contacts c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "Contacts.findByContactMail", query = "SELECT c FROM Contacts c WHERE c.contactMail = :contactMail"),
    @NamedQuery(name = "Contacts.findByContactDetails", query = "SELECT c FROM Contacts c WHERE c.contactDetails = :contactDetails"),
    @NamedQuery(name = "Contacts.findByStatus", query = "SELECT c FROM Contacts c WHERE c.status = :status")})
public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactID")
    private Integer contactID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ContactName")
    private String contactName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ContactMail")
    private String contactMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ContactDetails")
    private String contactDetails;
    @Column(name = "Status")
    private Short status;

    public Contacts() {
    }

    public Contacts(Integer contactID) {
        this.contactID = contactID;
    }

    public Contacts(Integer contactID, String contactName, String contactMail, String contactDetails) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactMail = contactMail;
        this.contactDetails = contactDetails;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contacts[ contactID=" + contactID + " ]";
    }
    
}
