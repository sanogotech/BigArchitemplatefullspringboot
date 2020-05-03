package jpqlexample.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import jpqlexample.entities.*;

public class NewEntityServlet extends HttpServlet {
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
        Customer cust = (Customer) em.find(Customer.class, 1);
        PurchaseOrder ord = new PurchaseOrder();
        ord.setOrder_date(new Date());
        ord.setCustomer(cust);
        cust.getPurchaseOrders().add(ord);
     //   em.persist(ord);
        em.flush();
        em.getTransaction().commit();
        out.println("Pono of the inserted order : "+ ord.getPono() +"<br/>");
    }
}
