import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/translate")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary=new HashMap<>();
        dictionary.put("hello","xin chao");
        dictionary.put("goodbye","tam biet");
        dictionary.put("good morning","chao buoi sang");
        dictionary.put("school","truong");
        dictionary.put("class","lop");
        dictionary.put("name","ten");
        dictionary.put("kiss","hon");
        dictionary.put("eat","an");
        String search =request.getParameter("txtSearch");
        PrintWriter writer= response.getWriter();

        writer.println("<html>");
        String result= dictionary.get(search);
        if (result !=null) {
            writer.println("<h1> " + search + " =>" + result + "</h1>");
            writer.println("</html>");
        }
        else writer.println("Not found");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
