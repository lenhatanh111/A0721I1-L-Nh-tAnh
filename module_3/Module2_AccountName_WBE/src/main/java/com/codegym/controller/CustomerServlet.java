package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                String customer_name = request.getParameter("customer_name");
                String customer_birthday = request.getParameter("customer_birthday");
                String customer_gender = request.getParameter("customer_gender");
                String customer_id_card = request.getParameter("customer_id_card");
                String customer_phone = request.getParameter("customer_phone");
                String customer_email = request.getParameter("customer_email");
                String customer_address = request.getParameter("customer_address");
                String customer_type_id = request.getParameter("customer_type_id");
               iCustomerService.create(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id);
               List<Customer> customerList= new ArrayList<>();
               customerList= iCustomerService.display();
               request.setAttribute("customerList",customerList);
                request.getRequestDispatcher("/display_Customer.jsp").forward(request, response);
                break;
            }
            case "delete":{
                String customer_id = request.getParameter("customer_id");
                System.out.println(customer_id);
                iCustomerService.delete(customer_id);
                List<Customer> customerList = new ArrayList<>();
                customerList = iCustomerService.display();
                request.setAttribute("listCustomer", customerList);
                request.getRequestDispatcher("/display_Customer.jsp").forward(request, response);
                break;
            }
            case "update":{
                String customer_name = request.getParameter("customer_name");
                String customer_birthday = request.getParameter("customer_birthday");
                String customer_gender = request.getParameter("customer_gender");
                String customer_id_card = request.getParameter("customer_id_card");
                String customer_phone = request.getParameter("customer_phone");
                String customer_email = request.getParameter("customer_email");
                String customer_address = request.getParameter("customer_address");
                String customer_type_id = request.getParameter("customer_type_id");
                iCustomerService.update(customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email,customer_address,customer_type_id);
                List<Customer> customerList = new ArrayList<>();
                customerList = iCustomerService.display();
                request.setAttribute("listCustomer", customerList);
                request.getRequestDispatcher("/display_Customer.jsp").forward(request, response);
                break;
            }
            case "search":{
                String customer_name = request.getParameter("customer_name");
                List<Customer> list = iCustomerService.search(customer_name);
                request.setAttribute("listCustomer", list);
                request.getRequestDispatcher("/display_Customer.jsp").forward(request, response);
                break;
            }
        }
        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            switch (action){
                case "display":{
                    List<Customer> customerList = new ArrayList<>();
                    customerList = iCustomerService.display();
                    request.setAttribute("listCustomer", customerList);
                    request.getRequestDispatcher("/display_Customer.jsp").forward(request, response);
                    break;
                }
                case "home":{
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    response.sendRedirect("/index.jsp");
                    break;
                }
                case "create":{
                    List<Customer> list = new ArrayList<>();
                    list = iCustomerService.display();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/create_customer.jsp").forward(request, response);
                    break;
                }
                case "delete":{
                    List<Customer> customerList = new ArrayList<>();
                    customerList = iCustomerService.display();
                    request.setAttribute("listCustomer", customerList);
                    request.getRequestDispatcher("/delete_customer.jsp").forward(request, response);
                    response.sendRedirect("/delete_customer.jsp");
                    break;
                }
                case "update":{
                   List<Customer> customerList = new ArrayList<>();
                    customerList = iCustomerService.display();
                    request.setAttribute("listCustomer", customerList);
                    request.getRequestDispatcher("/update_customer.jsp").forward(request, response);
                    response.sendRedirect("/update_customer.jsp");
                    break;
                }
            }
        }

        }

