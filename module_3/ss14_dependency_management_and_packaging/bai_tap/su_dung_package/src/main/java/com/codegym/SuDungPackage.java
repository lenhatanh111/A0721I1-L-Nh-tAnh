package com.codegym;

import java.util.List;

public class SuDungPackage {
    public static void main(String[] args) {
        int a =2;
        int b =5;
        int c =3;
        List<Double> results =GiaiPhuongTrinhBac2.gaiPtBac2(a,b,c);
        System.out.println("ket qua:");
        for (Double result: results
             ) {
            System.out.println("x =" +result);
        }
    }
}
