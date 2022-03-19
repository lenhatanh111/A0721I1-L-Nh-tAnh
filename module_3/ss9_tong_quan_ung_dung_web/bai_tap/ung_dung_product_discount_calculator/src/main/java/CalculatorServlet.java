import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/result")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
float list_price =Float.parseFloat(request.getParameter("list_price"));
float discount_percent=Float.parseFloat(request.getParameter("discount_percent"));
double result= list_price*discount_percent*0.01 ;
        PrintWriter writer =response.getWriter();
        writer.println("<html>");
writer.println("<h1>Discount Amount : "+result+"</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}