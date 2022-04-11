package controller;

import model.bean.Contract;
import model.bean.Contract_detail;
import model.service.IContractDetailService;
import model.service.impl.ContractDetailServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet" , urlPatterns = {"/contract_details"})

public class ContractDetailServlet extends HttpServlet {
    IContractDetailService contractDetailService = new ContractDetailServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addNewContractDetail(request, response);
            default:
                showContractDetailList(request,response);
        }
    }

    private void addNewContractDetail(HttpServletRequest request, HttpServletResponse response) {
        boolean check =false;

        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity =Integer.parseInt(request.getParameter("quantity"));
       Contract_detail contract_detail =new Contract_detail(contract_id,attach_service_id,quantity);
        try {
            check= contractDetailService.insertContractDetail(contract_detail);
            if (check){
                request.setAttribute("message", "Add New Contract Detail successful");
            }else {
                request.setAttribute("message", "Add New Contract Detail failed");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("contractDetail/addContractDetail.jsp");
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
                showAddContractDetailForm(request,response);
                break;
            default:
                showContractDetailList(request,response);
                // hien thi danh sách
        }
    }

    private void showAddContractDetailForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher =request.getRequestDispatcher("contractDetail/addContractDetail.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractDetailList(HttpServletRequest request, HttpServletResponse response) {
        List<Contract_detail> contract_details = contractDetailService.selectAllContractsDetail();
        request.setAttribute("contract_details",contract_details);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contractDetail/listContractDetail.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
