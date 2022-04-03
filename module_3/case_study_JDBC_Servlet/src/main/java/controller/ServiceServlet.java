package controller;

import model.bean.Customer;
import model.bean.Service;
import model.repository.IServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.IServiceService;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/services"})
public class ServiceServlet extends HttpServlet {
   private IServiceService serviceService =new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
            addNewService(request, response);
            default:
                showServiceList(request,response);
        }


    }

    private void addNewService(HttpServletRequest request, HttpServletResponse response) {
       boolean check =false;
        String name= request.getParameter("name");
        int service_area = Integer.parseInt(request.getParameter("area"));
        double cost= Double.parseDouble(request.getParameter("cost"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        int max_people =Integer.parseInt(request.getParameter("max_people"));
       Service service=new Service(name,service_area,cost,max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
        try {
           check= serviceService.insertService(service);
            if (check){
                request.setAttribute("message", "Add New Service successful");
            }else {
                request.setAttribute("message", "Add New Service failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("service/addService.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddServiceForm(request,response);
                break;
            default:
                showServiceList(request,response);
                // hien thi danh sách
        }
    }

    private void showAddServiceForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher =request.getRequestDispatcher("service/addService.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> services = serviceService.selectAllServices();
        request.setAttribute("services",services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/listService.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
