package jpqlexample.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@Table(name = "SHIPPINGINFO")
public class ShippingInfo implements Serializable {
    @Id
    @Column(name = "SHIP_CUST_ID")
    private Integer ship_cust_id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private String zip;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "SHIP_CUST_ID",referencedColumnName = "CUST_ID")
    private Customer customer;
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public ShippingInfo() {
    }   
    public Integer getShip_cust_id() {
        return this.ship_cust_id;
    }
    public void setShip_cust_id(Integer ship_cust_id) {
        this.ship_cust_id = ship_cust_id;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return this.zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
}
