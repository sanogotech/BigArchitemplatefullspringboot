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

public class ContextServlet extends HttpServlet {
    @PersistenceUnit(unitName="jpqlexample-pu")
    private EntityManagerFactory emf;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        EntityManager em = emf.createEntityManager();
        PrintWriter out = response.getWriter();
        em.getTransaction().begin();
        PurchaseOrder ord = (PurchaseOrder)em.createQuery("SELECT o FROM PurchaseOrder o WHERE o.pono = 1")
                              .getSingleResult(); 
        List<OrderLineItem> items = ord.getOrderLineItems();
        Integer qnt = items.get(0).getQuantity();
        out.println("Quantity of the first element : "+ qnt +"<br/>");
        items.get(0).setQuantity(qnt+1);
        qnt = items.get(0).getQuantity();
        em.getTransaction().commit();
        out.println("Quantity of the first element : "+ qnt +"<br/>");
    }
}
