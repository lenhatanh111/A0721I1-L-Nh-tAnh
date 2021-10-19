package ss6_ke_thua.bai_tap.bai_4_thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào độ dài 3 cạnh của tam giác");
        double side1=Double.parseDouble(scanner.nextLine());
        double side2=Double.parseDouble(scanner.nextLine());
        double side3=Double.parseDouble(scanner.nextLine());
        System.out.println("nhập màu sắc của tam giác");
        String color=scanner.nextLine();
        System.out.println("tam giác có phải filled?");
        boolean filled=scanner.hasNext();
        if (side1+side2>side3 || side1+side3>side2 || side2+side3>side1){
            Triangle triangle=new Triangle(color,filled,side1,side2,side3);
            System.out.println(triangle);
        }else{
            System.out.println("bạn nhập vào k phải 1 tam giác!");
        }
    }
}
