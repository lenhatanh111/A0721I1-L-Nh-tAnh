import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       float first_operand =Float.parseFloat(request.getParameter("firstOperand"));
        float second_operand = Float.parseFloat(request.getParameter("secondOperand"));
        char operator =request.getParameter("operator").charAt(0);
        PrintWriter printWriter =response.getWriter();
        request.setAttribute("firstOperand",first_operand);
        request.setAttribute("secondOperand",second_operand);
        request.setAttribute("Operator",operator);

try {
    float result =Calculator.calculate(first_operand,second_operand,operator);

    request.setAttribute("Result",result);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewResult.jsp");
    requestDispatcher.forward(request,response);
}catch (Exception exception){
    printWriter.println("<html>");
    printWriter.println("<h1 style='color: red'> Error :"+exception.getMessage()+"</h1>");
    printWriter.println("</html>");
}



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
