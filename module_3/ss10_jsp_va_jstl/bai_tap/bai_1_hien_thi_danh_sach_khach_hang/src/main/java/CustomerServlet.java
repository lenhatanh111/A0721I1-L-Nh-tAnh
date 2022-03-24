import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/view")
public class CustomerServlet extends HttpServlet {
   private static List<Customer> customerList=new ArrayList<>();
    static {
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
        customerList.add(new Customer("nhat anh","28/01/2000","quang ngai","/anh_chan_dung.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("list_customer",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request,response);
    }

}
