package com.codegym;

import java.util.ArrayList;
import java.util.List;

public class GiaiPhuongTrinhBac2 {
    public static void main(String[] args) {

    }
    public static List<Double> gaiPtBac2(int a,int b,int c){
        List<Double> results =new ArrayList<>();
        double delta =b*b - 4*a*c;
        if (delta <0){
            return null;
        }else if(delta ==0){
            results.add((double) (-b/2*a));
        }else {
            results.add((-b+Math.sqrt(delta))/2*a);
            results.add((-b-Math.sqrt(delta))/2*a);
        }
        return results;
    }
}
