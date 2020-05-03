 package jpqlexample.servlets;
 public class LineItemSum {
           private Double price;
           private Integer quantity;
           private Double rslt;
           public LineItemSum (Double price, Integer quantity){
             this.rslt = quantity*price;
           }
           public Double getRslt () {
            return this.rslt;
           }
           public void setRslt (Double rslt) {
            this.rslt = rslt;
           }
        }
