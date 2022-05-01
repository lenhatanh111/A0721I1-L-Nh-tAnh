package controller;

import model.bean.Customer;
import model.bean.Customer_type;
import model.service.ICustomerService;
import model.service.ICustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

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
    private ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
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

        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        Integer gender=Integer.parseInt(request.getParameter("gender"));
        String id_card=request.getParameter("id_card");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int type_id=Integer.parseInt(request.getParameter("type_id"));
        Customer customer = new Customer(name,birthday,gender,id_card,phone,email,address,type_id);


        List<String> messList = null;
        try {
            messList = customerService.insertCustomer(customer);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        boolean check =true;
        for (String mess: messList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String message = "Them moi thanh cong";
        if (!check) {
            message = "them moi khong thanh cong";
        }
        request.setAttribute("message",message);
        request.setAttribute("messList",messList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/addCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {

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
        List<String> messList = null;
        try {
            messList = customerService.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean check =true;
        for (String mess: messList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String message = "Chinh sua thanh cong";
        if (!check) {
            message = "chinh sua khong thanh cong";
        }
        request.setAttribute("message",message);
        request.setAttribute("messList",messList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        try {
            dispatcher.forward(request, response);
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
            List<Customer> customers=customerService.selectAllCustomers();
            request.setAttribute("customers",customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/listCustomer.jsp");
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

        List<Customer_type> customer_types =customerTypeService.findAll();
        request.setAttribute("customer_types",customer_types);
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
        List<Customer_type> customer_types =customerTypeService.findAll();
        request.setAttribute("customer_types",customer_types);
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