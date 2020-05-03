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
public class SingleColumnServlet extends HttpServlet {
    @PersistenceUnit(unitName="jpqlexample-pu")
    private EntityManagerFactory emf;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        EntityManager em = emf.createEntityManager();
        PrintWriter out = response.getWriter();
        Integer cust_id =2;
        String cust_name = (String)em.createQuery("SELECT c.cust_name FROM Customer c WHERE c.cust_id=:cust_id")
                              .setParameter("cust_id", cust_id)
                              .getSingleResult(); 
        out.println("Customer with id "+cust_id+" is: "+cust_name+"<br/>");
        List<String> arr_cust_name = (List<String>)em.createQuery("SELECT c.cust_name FROM Customer c")
                              .getResultList(); 
        out.println("List of all customers: "+"<br/>");
        Iterator i = arr_cust_name.iterator();
   //     String cust_name;
        while (i.hasNext()) {
            cust_name = (String) i.next();
            out.println(cust_name+"<br/>");
        }
    }
}
