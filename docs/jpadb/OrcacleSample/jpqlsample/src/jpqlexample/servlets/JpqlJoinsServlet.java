package jpqlexample.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Iterator;
import jpqlexample.entities.*;


public class JpqlJoinsServlet extends HttpServlet {
    @PersistenceUnit(unitName="jpqlexample-pu")
    private EntityManagerFactory emf;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        EntityManager em = emf.createEntityManager();
        Double max = (Double) em.createQuery("SELECT MAX(p.price) FROM PurchaseOrder o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'")
                              .getSingleResult(); 
        out.println("The highest price for an ordered product supplied by Tortuga Trading: "+ max + "<br/>");

        List<LineItemSum> arr = (List<LineItemSum>)em.createQuery("SELECT NEW jpqlexample.servlets.LineItemSum(p.price, l.quantity) FROM PurchaseOrder o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'")
                              .getResultList(); 

        Iterator i = arr.iterator();
        LineItemSum lineItemSum;
        Double sum = 0.0;
        while (i.hasNext()) {
            lineItemSum = (LineItemSum) i.next();
            sum = sum + lineItemSum.getRslt();
        }
        out.println("The total cost of the ordered products supplied by Tortuga Trading: "+ sum + "<br/>");
    }
}
