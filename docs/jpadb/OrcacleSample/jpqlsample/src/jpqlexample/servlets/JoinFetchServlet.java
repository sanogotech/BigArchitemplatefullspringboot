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

public class JoinFetchServlet extends HttpServlet {
    @PersistenceUnit(unitName="jpqlexample-pu")
    private EntityManagerFactory emf;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        EntityManager em = emf.createEntityManager();
        PrintWriter out = response.getWriter();
        Customer cust = (Customer)em.createQuery("SELECT DISTINCT c FROM Customer c LEFT JOIN FETCH c.purchaseOrders WHERE c.cust_id=1")
                              .getSingleResult(); 

        List<PurchaseOrder> orders = cust.getPurchaseOrders();
        Iterator i = orders.iterator();
        PurchaseOrder order;
        while (i.hasNext()) {
            order = (PurchaseOrder) i.next();
            out.println("Order's pono : "+ order.getPono() +"<br/>");
        }
    }
}
