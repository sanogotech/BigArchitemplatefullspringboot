package jpqlexample.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
@Entity
@Table(name = "SUPPLIERS")
public class Supplier implements Serializable {
    @Id
    @Column(name = "SUP_ID")
    private Integer sup_id;
    @Column(name = "SUP_NAME")
    private String sup_name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy="supplier", cascade = CascadeType.ALL)
    private List<Product> products;
    public List<Product> getProducts(){
       return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Supplier() {
    }   
    public Integer getSup_id() {
        return this.sup_id;
    }
    public void setSup_id(Integer sup_id) {
        this.sup_id = sup_id;
    }
    public String getSup_name() {
        return this.sup_name;
    }
    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
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
