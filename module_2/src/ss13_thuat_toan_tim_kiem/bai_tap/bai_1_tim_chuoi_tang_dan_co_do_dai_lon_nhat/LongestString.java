package ss13_thuat_toan_tim_kiem.bai_tap.bai_1_tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.ArrayList;
import java.util.LinkedList;

public class LongestString {
    public static void main(String[] args) {


         String string = "AbceBCDEF";
        String[] arrayString = string.split("");
       LinkedList<String> listMax = new LinkedList<>();

        for (int i = 0; i < arrayString.length ; i++) {
            LinkedList<String> listTemp = new LinkedList<>();
            listTemp.add(arrayString[i]);
           for (int j=i+1;j<arrayString.length;j++){
               if (arrayString[j].charAt(0)>listTemp.getLast().charAt(0)){
                   listTemp.add(arrayString[j]);
               }
           }
           if (listTemp.size()>listMax.size()){
               listMax.clear();
               listMax.addAll(listTemp);
           }
        }
        System.out.println(listMax.toString());

    }

}
