package controller;

import model.bean.BenhAn;
import model.bean.BenhNhan;
import model.service.IBenhNhanService;
import model.service.impl.BenhNhanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BenhAnServlet",urlPatterns = {"/benhans"})
public class BenhAnServlet extends HttpServlet {
    private IBenhNhanService benhNhanService=new BenhNhanServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                save(request,response);
                break;
            case "delete":
                deteteBenhAn(request,response);

            default:
                showBenhAnList(request, response);
                // hien thi danh sách
        }
    }

    private void deteteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
        String id = request.getParameter("id");
        try {
            check = benhNhanService.delete(id);
            if (check) {
                request.setAttribute("message", "Delete successful");
            } else {
                request.setAttribute("message", "Delete failed");
            }
            List<BenhNhan> benhNhans = benhNhanService.findAll();
            request.setAttribute("benhNhans", benhNhans);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String ten_benh_nhan=request.getParameter("name");
        String ngay_nhap_vien=request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien=request.getParameter("ngay_ra_vien");
        String ly_do=request.getParameter("ly_do");
        String ma_benh_nhan=request.getParameter("ma_benh_nhan");
        String ma_benh_an=request.getParameter("ma_benh_an");
        boolean check=false;
        check=benhNhanService.edit(new BenhNhan(ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do,ma_benh_an));
        if (check){
            request.setAttribute("message","chinh sua thanh cong");
        }else request.setAttribute("message","chinh sua that bai");
       List<BenhNhan> benhNhans=benhNhanService.findAll();
       request.setAttribute("benhNhans",benhNhans);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
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
            case "edit":
               showEditBenhAnForm(request,response);
                break;

            default:
                showBenhAnList(request, response);
                // hien thi danh sách
        }
    }

    private void showEditBenhAnForm(HttpServletRequest request, HttpServletResponse response) {
        String ma_benh_nhan=request.getParameter("id");
        BenhNhan benhNhan=benhNhanService.findBenhNhanByID(ma_benh_nhan);
        RequestDispatcher dispatcher=request.getRequestDispatcher("view/edit.jsp");
        request.setAttribute("benhNhan",benhNhan);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBenhAnList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhNhan> benhNhans=benhNhanService.findAll();
        request.setAttribute("benhNhans",benhNhans);
        RequestDispatcher dispatcher=request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
