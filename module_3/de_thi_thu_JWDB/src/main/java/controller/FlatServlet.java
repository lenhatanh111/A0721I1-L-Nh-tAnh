package controller;

import model.bean.Flat;
import model.bean.FlatType;
import model.bean.Floor;
import model.bean.Status;
import model.service.IFlatService;
import model.service.IFlatTypeService;
import model.service.IFloorService;
import model.service.IStatusService;
import model.service.impl.FlatServiceImpl;
import model.service.impl.FlatTypeServiceImpl;
import model.service.impl.FloorServiceImpl;
import model.service.impl.StatusServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlatServlet",urlPatterns = {"/flats"})
public class FlatServlet extends HttpServlet {
    private IStatusService statusService=new StatusServiceImpl();
    private IFloorService floorService =new FloorServiceImpl();
    private IFlatTypeService flatTypeService=new FlatTypeServiceImpl();
    private IFlatService flatService = new FlatServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addFlat(request,response);
                break;
            case "search":
                searchFlat(request, response);
            case "delete":
                deleteFlat(request,response);


            default:
        }
    }

    private void deleteFlat(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        boolean check=false;
        check=flatService.delete(id);
        if (check){
            request.setAttribute("message","delete successfully");
        }else request.setAttribute("message","delete failure");
        request.setAttribute("flats",flatService.findAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("flat/listFlat.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addFlat(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        int status_id=Integer.parseInt(request.getParameter("status_id"));
        int area=Integer.parseInt(request.getParameter("area"));
        int floor_id=Integer.parseInt(request.getParameter("floor_id"));
        int type_id=Integer.parseInt(request.getParameter("type_id"));
        double cost=Double.parseDouble(request.getParameter("cost"));
        String start_date=request.getParameter("start_date");
        String end_date=request.getParameter("end_date");
        String description=request.getParameter("description");
        boolean check=true;
        List<String> messList=flatService.add(new Flat(id,status_id,area,floor_id,type_id,cost,start_date,end_date,description));
        for (String mess:messList) {
            if (!mess.equals("")){
                check=false;
            }
        }
        String message="add new successfully";
        if(!check){
            message="add new failure ";
        }
        request.setAttribute("messList",messList);
        request.setAttribute("message",message);
        request.setAttribute("flats",flatService.findAll());
        if (check) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("flat/listFlat.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("flat/addFlat.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void searchFlat(HttpServletRequest request, HttpServletResponse response) {
        String type_id=request.getParameter("type_id");
        String floor=request.getParameter("floor");
        String start_date=request.getParameter("start_date");
        String end_date=request.getParameter("end_date");
       List<Flat> flats = flatService.search(type_id,start_date,end_date,floor);
       if (flats.size()==0){
           request.setAttribute("message","NOT FOUND");
       }
       request.setAttribute("flats",flats);
       RequestDispatcher dispatcher=request.getRequestDispatcher("flat/searchFlat.jsp");
        try {
            dispatcher.forward(request,response);
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
                showAddFlatForm(request,response);
                break;
            case "search":
                showSearchForm(request,response);


            default:
                showflatList(request,response);
                // hien thi danh sách
        }
    }

    private void showAddFlatForm(HttpServletRequest request, HttpServletResponse response) {
        List<FlatType> flatTypes=flatTypeService.findAll();
        List<Floor> floors=floorService.findAll();
        List<Status> statuses=statusService.findAll();
        request.setAttribute("flatTypes",flatTypes);
        request.setAttribute("floors",floors);
        request.setAttribute("statuses",statuses);
        RequestDispatcher dispatcher =request.getRequestDispatcher("flat/addFlat.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        List<FlatType> flatTypes=flatTypeService.findAll();
       List<Floor> floors=floorService.findAll();
       request.setAttribute("flatTypes",flatTypes);
       request.setAttribute("floors",floors);
       RequestDispatcher dispatcher =request.getRequestDispatcher("flat/searchFlat.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showflatList(HttpServletRequest request, HttpServletResponse response) {
        List<Flat> flats= flatService.findAll();
        request.setAttribute("flats",flats);
        RequestDispatcher dispatcher=request.getRequestDispatcher("flat/listFlat.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

