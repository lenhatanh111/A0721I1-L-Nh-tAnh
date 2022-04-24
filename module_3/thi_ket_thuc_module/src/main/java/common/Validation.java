package common;



import java.util.ArrayList;
import java.util.List;

public class Validation {

    public static boolean checkname(String name){
        String regex="^[A-Za-z]{3,}$";
        return name.matches(regex);

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
