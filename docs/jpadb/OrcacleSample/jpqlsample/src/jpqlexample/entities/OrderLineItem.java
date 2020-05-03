package jpqlexample.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "ORDERLINEITEMS")
@IdClass(value = jpqlexample.entities.OrderLineItemKey.class)
public class OrderLineItem implements Serializable {
    @Id
    @Column(name = "ITEMNO")
    private Integer itemno;
    @Id
    @Column(name = "PONO", insertable=false, updatable=false)
    private Integer pono;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(
      name="PONO",
      referencedColumnName="PONO")
    private PurchaseOrder purchaseOrder;

    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }
    public void setPurchaseOrder (PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
    @ManyToOne
    @JoinColumn(
      name="PROD_ID",
      referencedColumnName="PROD_ID")
    private Product product;

    public Product product() {
        return this.product;
    }
    public void setProduct (Product product) {
        this.product = product;
    }

    public OrderLineItem() {
    }   
    public Integer getItemno() {
        return this.itemno;
    }
    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity= quantity;
    }
}
