package controller;

import model.bean.Contract;
import model.bean.Service;
import model.service.IContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contracts"})
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addNewContract(request, response);
            default:
                showContractList(request,response);
        }
    }

    private void addNewContract(HttpServletRequest request, HttpServletResponse response) {
        boolean check =false;
        String start_date= request.getParameter("start_date");
        String end_date= request.getParameter("end_date");
        double deposit= Double.parseDouble(request.getParameter("deposit"));
        double total_money= Double.parseDouble(request.getParameter("total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id =Integer.parseInt(request.getParameter("service_id"));
       Contract contract =new Contract(start_date,end_date,deposit,total_money,employee_id,customer_id,service_id);
        try {
            check= contractService.insertContract(contract);
            if (check){
                request.setAttribute("message", "Add New Contract successful");
            }else {
                request.setAttribute("message", "Add New Contract failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("contract/addContract.jsp");
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
                showAddContractForm(request,response);
                break;
            default:
                showContractList(request,response);
                // hien thi danh sách
        }
    }

    private void showAddContractForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher =request.getRequestDispatcher("contract/addContract.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts = contractService.selectAllContracts();
        request.setAttribute("contracts",contracts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/listContract.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
