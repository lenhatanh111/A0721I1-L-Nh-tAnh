import javax.servlet.RequestDispatcher;
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
        double list_price = Double.parseDouble(request.getParameter("list_price"));
        double discount_percent = Double.parseDouble(request.getParameter("discount_percent"));
        double result = list_price * discount_percent * 0.01;
        request.setAttribute("ket_qua",result);
        request.setAttribute("gia",list_price);
        request.setAttribute("chiet_khau",discount_percent);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("hien_thi_ket_qua.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
