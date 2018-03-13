/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khanh
 */
@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByQuantity", query = "SELECT p FROM Products p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Products.findByPriceIn", query = "SELECT p FROM Products p WHERE p.priceIn = :priceIn"),
    @NamedQuery(name = "Products.findByPriceOut", query = "SELECT p FROM Products p WHERE p.priceOut = :priceOut"),
    @NamedQuery(name = "Products.findByProductDetail", query = "SELECT p FROM Products p WHERE p.productDetail = :productDetail"),
    @NamedQuery(name = "Products.findByImage", query = "SELECT p FROM Products p WHERE p.image = :image"),
    @NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status"),
    @NamedQuery(name = "Products.findByOrderCount", query = "SELECT p FROM Products p WHERE p.orderCount = :orderCount")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PriceIn")
    private long priceIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PriceOut")
    private long priceOut;
    @Size(max = 1000)
    @Column(name = "ProductDetail")
    private String productDetail;
    @Size(max = 200)
    @Column(name = "Image")
    private String image;
    @Column(name = "Status")
    private Short status;
    @Column(name = "OrderCount")
    private Integer orderCount;
    @JoinColumn(name = "BrandID", referencedColumnName = "BrandID")
    @ManyToOne(optional = false)
    private Brands brandID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private Categories categoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<OrderDetails> orderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<Comments> commentsCollection;

    public Products() {
    }

    public Products(Integer productID) {
        this.productID = productID;
    }

    public Products(Integer productID, String productName, int quantity, long priceIn, long priceOut) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(long priceIn) {
        this.priceIn = priceIn;
    }

    public long getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(long priceOut) {
        this.priceOut = priceOut;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Brands getBrandID() {
        return brandID;
    }

    public void setBrandID(Brands brandID) {
        this.brandID = brandID;
    }

    public Categories getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Categories categoryID) {
        this.categoryID = categoryID;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Products[ productID=" + productID + " ]";
    }
    
}
