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
@Table(name = "ORDERS")
public class PurchaseOrder implements Serializable {
    @SequenceGenerator(name = "ponoGen", 
                    sequenceName = "PONO_GEN_SEQUENCE", 
                    initialValue = 10, 
                    allocationSize = 1)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ponoGen")
    @Column(name = "PONO")
    private Integer pono;
    @Column(name = "ORDER_DATE")
    @Temporal(DATE)
    private Date order_date;
    @ManyToOne
    @JoinColumn(
      name="CUST_ID",
      referencedColumnName="CUST_ID")
    private Customer customer;
    @OneToMany(mappedBy="purchaseOrder", cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
    public List<OrderLineItem> getOrderLineItems(){
       return orderLineItems;
    }
    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public PurchaseOrder() {
    }   
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Integer getPono () {
        return this.pono;
    }
    public void setPono (Integer pono) {
        this.pono = pono;
    }
    public Date getOrder_date () {
        return this.order_date;
    }
    public void setOrder_date (Date order_date) {
        this.order_date = order_date;
    }
}
