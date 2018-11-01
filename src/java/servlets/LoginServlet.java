package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

   public void doGet(HttpServletRequest req, HttpServletResponse resp)
   {
        try
        {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.print("<h1>Login is Sucessful</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
        catch(IOException exception)
        {
            System.out.println("IO related exception has occured");
        }
       
       
       
   }
 
}
