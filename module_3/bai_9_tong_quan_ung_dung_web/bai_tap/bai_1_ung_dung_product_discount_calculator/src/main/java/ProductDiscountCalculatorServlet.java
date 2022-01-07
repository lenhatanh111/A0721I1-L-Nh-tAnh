import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet", value = "/transfrom")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            double cost = Double.parseDouble(request.getParameter("cost"));
            double discount = Double.parseDouble(request.getParameter("discount"));
            double result = cost*0.01*discount;
            PrintWriter writer = response.getWriter();
            writer.println("Result: " +result);
    }
}
