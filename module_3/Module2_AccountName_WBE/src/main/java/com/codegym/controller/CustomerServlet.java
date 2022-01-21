package com.codegym.controller;

import com.codegym.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CustomerService customerService;

    public void init() {
        customerService = new CustomerService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        insertCustomer(request, response);
                        break;
                    case "edit":
                        updateCustomer(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
