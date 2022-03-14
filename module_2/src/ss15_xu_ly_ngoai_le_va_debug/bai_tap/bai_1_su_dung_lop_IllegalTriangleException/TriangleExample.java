package ss15_xu_ly_ngoai_le_va_debug.bai_tap.bai_1_su_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class TriangleExample {
    public static void triangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("cạnh tam giác không thể nhỏ hơn hoặc bằng 0");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("không phải 3 cạnh của 1 tam giác");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào 3 cạnh a,b,c của 1 tam giác");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        try {
            triangle(a, b, c);
            System.out.println(a + ", " + b + ", " + c + ", " + "là 3 cạnh của 1 tam giác");
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
