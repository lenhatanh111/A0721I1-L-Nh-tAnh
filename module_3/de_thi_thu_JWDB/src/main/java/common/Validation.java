package common;

import model.bean.Flat;
import model.service.IFlatService;
import model.service.impl.FlatServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public static boolean checkFlatID(String id){
        String regex="^[A-Z0-9]{3}[-][A-Z0-9]{2}[-][A-Z0-9]{2}$";
        return id.matches(regex);

    }
    public static boolean checkArea(int area){
        if (area>20){
            return true;
        }else return false;
    }
    public static boolean checkCost(double cost){
        if (cost>1000000){
            return true;
        }else return false;
    }
    public static boolean checkExist(String id){
        IFlatService flatService=new FlatServiceImpl();
        List<Flat> flats=flatService.findAll();
        boolean check=false;
        for (Flat flat:flats) {
            if (flat.getFlat_id().equals(id)){
                check=true;
            }
        }
        return check;
    }
    public static boolean checkDate(String start,String end){
        boolean check=false;
        String[] start_date=start.split("-");
        String[] end_date=end.split("-");
        if (Integer.parseInt(start_date[0])==Integer.parseInt(end_date[0])){
            if (Integer.parseInt(start_date[1])+6<=Integer.parseInt(end_date[1])){
                check=true;
            }
        }else if (Integer.parseInt(end_date[0])-Integer.parseInt(start_date[0])==1){
            if (Integer.parseInt(start_date[1])>6 &&(12- Integer.parseInt(start_date[1])+Integer.parseInt(end_date[1]))>=6){
                check=true;
            }else if(Integer.parseInt(start_date[1])<=6 && Integer.parseInt(start_date[1])+6<=Integer.parseInt(end_date[1])){
                check=true;
            }
        }else if (Integer.parseInt(end_date[0])-Integer.parseInt(start_date[0])>1){
            check=true;
        }
        return check;

    }
}
