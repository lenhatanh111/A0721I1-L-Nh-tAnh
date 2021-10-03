package ss2_vong_lap_java.thuc_hanh.bai_3_tim_uoc_chung_lon_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập số nguyên dương a: ");
        int a = scanner.nextInt();
        System.out.println(" nhập số nguyên dương b: ");
        int b = scanner.nextInt();
        int max = 1;
        if (a == 0 || b == 0) {
            System.out.println(" không có ước chung lớn nhất!");
        } else {
            if (a > b) {
                for (int i = 1; i <= b; i++) {
                    if (a % i == 0 && b % i == 0) {
                        if (i > max) {
                            max = i;
                        }
                    }
                }
            } else {
                for (int i = 1; i <= a; i++) {
                    if (a % i == 0 && b % i == 0) {
                        if (i > max) {
                            max = i;
                        }
                    }
                }
            }
            System.out.println("ước chung lớn nhất của 2 số " + a + " và " + b + " là: " + max);
        }
    }
}
