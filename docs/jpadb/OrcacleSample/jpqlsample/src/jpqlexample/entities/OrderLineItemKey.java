package jpqlexample.entities;
import java.io.Serializable;

public final class OrderLineItemKey implements Serializable {
 public Integer itemno;
 public Integer pono;
 public OrderLineItemKey() {}
 public OrderLineItemKey(Integer itemno, Integer pono) {
  this.itemno = itemno;
  this.pono = pono;
 }

public boolean equals(Object obj) {
 if (this == obj) {
  return true;
 }
 if (obj == null) {
  return false;
 }
 if (!(obj instanceof OrderLineItemKey)) {
  return false;
 }
 OrderLineItemKey other = (OrderLineItemKey) obj;
 if (itemno != null && other.itemno != null && this.itemno.equals(other.itemno)) {
   return (pono != null && other.pono!= null && this.pono.equals(other.pono));
  }
  return false;
}

public int hashCode() {
 if (itemno!=null && pono!=null) {
  return (itemno.hashCode() ^ pono.hashCode());
 }
 return 0;
}

}