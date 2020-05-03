package jpqlexample.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
    @Id
    @Column(name = "PROD_ID")
    private Integer prod_id;
    @Column(name = "PROD_NAME")
    private String prod_name;
    @Column(name = "PRICE")
    private Double price;
    @ManyToOne
    @JoinColumn(
      name="SUP_ID",
      referencedColumnName="SUP_ID")
    private Supplier supplier;
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
    public List<OrderLineItem> getOrderLineItems(){
       return orderLineItems;
    }
    public void setItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Product() {
    }   
    public Supplier getSupplier() {
        return this.supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Integer getProd_id () {
        return this.prod_id;
    }
    public void setProd_id (Integer prod_id) {
        this.prod_id = prod_id;
    }
    public String getProd_name () {
        return this.prod_name;
    }
    public void setProd_name (String prod_name) {
        this.prod_name = prod_name;
    }
    public Double getPrice () {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
