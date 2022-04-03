package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
               addCustomer(request,response);
                
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;

            case "search":
                searchCustomersByName(request,response);
                break;
            default:
                // hien thi danh sách

    }}

    private void searchCustomersByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customers = customerService.findCustomersByName(name);
        if (customers.size()==0){
            request.setAttribute("message", "NOT FOUND CUSTOMER");
        }
        request.setAttribute("customers",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check =false;
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        Integer gender=Integer.parseInt(request.getParameter("gender"));
        String id_card=request.getParameter("id_card");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int type_id=Integer.parseInt(request.getParameter("type_id"));
        Customer customer = new Customer(name,birthday,gender,id_card,phone,email,address,type_id);
        try {
            check= customerService.insertCustomer(customer);
            if (check){
                request.setAttribute("message", "Add New Customer successful");
            }else {
                request.setAttribute("message", "Add New Customer failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/addCustomer.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check =false;
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        Integer gender=Integer.parseInt(request.getParameter("gender"));
        String id_card=request.getParameter("id_card");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int type_id=Integer.parseInt(request.getParameter("type_id"));
        Customer customer = new Customer(id,name,birthday,gender,id_card,phone,email,address,type_id);
        try {
           check= customerService.updateCustomer(customer);
            if (check){
                request.setAttribute("message", "Update successful");
            }else {
                request.setAttribute("message", "update failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
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
               showAddCustomerForm(request,response);
                break;
            case "edit":
                showEditCustomerForm(request,response);
                break;

            default:
                showCustomerList(request,response);
                // hien thi danh sách
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check=false;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            check=customerService.deleteCustomer(id);
            if (check){
                request.setAttribute("message", "Delete successful");
            }else {
                request.setAttribute("message", "Delete failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/addCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
       Customer customer =customerService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        request.setAttribute("customer", customer);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomers();
        request.setAttribute("customers",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
