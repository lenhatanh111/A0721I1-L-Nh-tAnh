package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.service.IContractService;
import model.service.ICustomerService;
import model.service.IServiceService;
import model.service.impl.ContractServiceImpl;
import model.service.impl.CustomerServiceImpl;
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

@WebServlet(name = "CustomerUsingServiceServlet", urlPatterns = {"/customer_service"})
public class CustomerUsingServiceServlet extends HttpServlet {
    IContractService contractService = new ContractServiceImpl();
    IServiceService serviceService = new ServiceServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "delete":
//                deleteServiceOfCustomer(request, response);
//                break;
            case "edit":
                updateServiceOfCustomer(request, response);
                break;
            case "search":
                searchService(request,response);
            default:
                showListCustomerAreUsingService(request, response);
                // hien thi danh sách
        }
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Service> services = serviceService.findServicesByName(name);
        if (services.size()==0){
            request.setAttribute("message", "NOT FOUND SERVICE");
        }
        request.setAttribute("services",services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/listService.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // khi chỉnh sửa dịch vụ của 1 khách hàng đang sử dụng thì sẽ tạo ra 1 dịch vụ mới
    private void updateServiceOfCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
       int customer_id =Integer.parseInt(request.getParameter("customer_id"));
       int new_service_id =Integer.parseInt(request.getParameter("service_id"));
       int old_service_id =Integer.parseInt(request.getParameter("old_service_id"));

        try {

            check = contractService.updateServiceForContract(new_service_id, customer_id,old_service_id);

            if (check) {
                request.setAttribute("message", "Update successful");
            } else {
                request.setAttribute("message", "update failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_service/editCustomerServiceIsUsing.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void deleteServiceOfCustomer(HttpServletRequest request, HttpServletResponse response) {
//        boolean check = false;
//        int customer_id = Integer.parseInt(request.getParameter("id"));

//       Service service =serviceService.selectService(customer_id);
//        int service_id = service.getService_id();
//        try {
//            check = serviceService.deleteService(customer_id,service_id);
//            if (check) {
//                request.setAttribute("message", "Delete successful");
//            } else {
//                request.setAttribute("message", "Delete failed");
//            }
//            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//            dispatcher.forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;

            default:
                showListCustomerAreUsingService(request, response);
                // hien thi danh sách
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
      Service service =serviceService.selectServiceByName(name);
      List<Service> services =serviceService.selectAllServices();
      int id=Integer.parseInt(request.getParameter("id"));
      int s_id=service.getService_id();
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_service/editCustomerServiceIsUsing.jsp");
        request.setAttribute("service",service);
        request.setAttribute("services",services);
        request.setAttribute("customer_id",id);
        request.setAttribute("s_id",s_id);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomerAreUsingService(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomersAreUsingService();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer_service/listCustomerAreUsingService.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
