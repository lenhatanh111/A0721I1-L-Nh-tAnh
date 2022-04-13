package controller;

import model.bean.*;
import model.service.IDivisionService;
import model.service.IEducationDegreeService;
import model.service.IEmployeeService;
import model.service.IPositionService;
import model.service.impl.DivisionServiceImpl;
import model.service.impl.EducationDegreeServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet" ,urlPatterns = {"/employees"})
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeServiceImpl();
   IPositionService positionService = new PositionServiceImpl();
    IEducationDegreeService educationDegreeService =new EducationDegreeServiceImpl();
    IDivisionService divisionService =new DivisionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);

                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;

            case "search":
                searchEmployee(request, response);
                break;
            default:
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> employees = employeeService.findEmployeesByName(name);
        if (employees.size()==0){
            request.setAttribute("message", "NOT FOUND EMPLOYEE");
        }
        request.setAttribute("employees",employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/listEmployee.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean check=false;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            check=employeeService.deleteEmployee(id);
            if (check){
                request.setAttribute("message", "Delete successful");
            }else {
                request.setAttribute("message", "Delete failed");
            }
            List<Employee> employees=employeeService.selectAllEmployees();
            request.setAttribute("employees",employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/listEmployee.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean check =true;
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        String id_card=request.getParameter("id_card");
        Double salary =Double.parseDouble(request.getParameter("salary"));
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int position_id=Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id=Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id=Integer.parseInt(request.getParameter("division_id"));

        Employee employee = new Employee(name,birthday,id_card,salary,phone,email,address,position_id,education_degree_id,division_id,email);
        List<String> messList = null;
        try {
            messList=employeeService.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String message: messList) {
            if (!message.equals("")){
                check=false;
            }
        }
        String message="them moi thanh cong";
        if (!check){
            message="them moi that bai";
        }
        request.setAttribute("message",message);
        request.setAttribute("messList",messList);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("employee/addEmployee.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean check =true;
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        String id_card=request.getParameter("id_card");
        Double salary =Double.parseDouble(request.getParameter("salary"));
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int position_id=Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id=Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id=Integer.parseInt(request.getParameter("division_id"));
        String username=request.getParameter("email");
        Employee employee = new Employee(id,name,birthday,id_card,salary,phone,email,address,position_id,education_degree_id,division_id,username);

        List<String> messList = null;
        try {
            messList=employeeService.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String message: messList) {
            if (!message.equals("")){
                check=false;
            }
        }
        String message="chinh sua thanh cong";
        if (!check){
            message="chinh sua that bai";
        }
        request.setAttribute("message",message);
        request.setAttribute("messList",messList);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("employee/editEmployee.jsp");
        try {
            requestDispatcher.forward(request,response);
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
                showAddEmployeeForm(request, response);
                break;
            case "edit":
                showEditEmployeeForm(request, response);
                break;

            default:
                showEmployeeList(request, response);
                // hien thi danh sách
        }
    }

    private void showAddEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positions=positionService.findAll();
        List<Education_degree> education_degrees=educationDegreeService.findAll();
        List<Division> divisions=divisionService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/addEmployee.jsp");
        request.setAttribute("positionList",positions);
        request.setAttribute("education_degrees",education_degrees);
        request.setAttribute("divisions",divisions);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee =employeeService.selectEmployee(id);
        List<Position> positions=positionService.findAll();
        List<Education_degree> education_degrees=educationDegreeService.findAll();
        List<Division> divisions=divisionService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/editEmployee.jsp");
        request.setAttribute("employee", employee);
        request.setAttribute("positions",positions);
        request.setAttribute("education_degrees",education_degrees);
        request.setAttribute("divisions",divisions);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.selectAllEmployees();

        request.setAttribute("employees",employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/listEmployee.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

