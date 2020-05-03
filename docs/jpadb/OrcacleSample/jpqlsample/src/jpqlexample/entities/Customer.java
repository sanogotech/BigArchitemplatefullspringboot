package jpqlexample.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
    @Id
    @Column(name = "CUST_ID")
    private Integer cust_id;
    @Column(name = "CUST_NAME", nullable = false)
    private String cust_name;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PHONE", nullable = false)
    private String phone;
    @OneToMany(mappedBy="customer", cascade = CascadeType.PERSIST)
    private List<PurchaseOrder> purchaseOrders;
    public List<PurchaseOrder> getPurchaseOrders(){
       return purchaseOrders;
    }
    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
    @OneToOne(mappedBy = "customer")
    private ShippingInfo shippingInfo;
    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }
    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public Customer() {
    }   
    public Integer getCust_id() {
        return this.cust_id;
    }
    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }
    public String getCust_name() {
        return this.cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
