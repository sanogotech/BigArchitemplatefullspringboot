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
public class SimpleQueryServlet extends HttpServlet {
    @PersistenceUnit(unitName="jpqlexample-pu")
    private EntityManagerFactory emf;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        EntityManager em = emf.createEntityManager();
        PrintWriter out = response.getWriter();
        List<Customer> arr_cust = (List<Customer>)em.createQuery("SELECT c FROM Customer c")
                              .getResultList(); 
        out.println("List of all customers: "+"<br/>");
        Iterator i = arr_cust.iterator();
        Customer cust;
        while (i.hasNext()) {
            cust = (Customer) i.next();
            out.println(cust.getCust_id()+"<br/>");
            out.println(cust.getCust_name()+"<br/>");
            out.println(cust.getEmail()+"<br/>");
            out.println(cust.getPhone()+"<br/>");
            out.println("----------------" + "<br/>");
        }
    }
}
