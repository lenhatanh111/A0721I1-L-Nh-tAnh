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
       float first_operand =Integer.parseInt(request.getParameter("first-operand"));
        float second_operand = Integer.parseInt(request.getParameter("second-operand"));
        char operator =request.getParameter("operator").charAt(0);
        PrintWriter printWriter =response.getWriter();
printWriter.println("<html>");
printWriter.println("<h1> Result : </h1>" );

try {
    float result =Calculator.calculate(first_operand,second_operand,operator);
    printWriter.println(first_operand + " "+ operator +" "+second_operand +" "+"="+" "+result);
}catch (Exception exception){
    printWriter.println("Error :"+exception.getMessage());
}
        printWriter.println("</html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
