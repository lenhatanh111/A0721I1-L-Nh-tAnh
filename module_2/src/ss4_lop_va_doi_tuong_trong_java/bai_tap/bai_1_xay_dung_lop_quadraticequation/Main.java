package ss4_lop_va_doi_tuong_trong_java.bai_tap.bai_1_xay_dung_lop_quadraticequation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhâp a,b,c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("phương trình có 2 nghiệm phân biệt: x1= " + quadraticEquation.getRoot1() + " " +
                    "x2= " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("phương trình có nghiệm kép x= " + quadraticEquation.getRoot2());
        } else {
            System.out.println("phương trình vô nghiệm!");
        }
    }
}
