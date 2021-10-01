package ss1_introduction_to_java.thuc_hanh.bai_6_kiem_tra_nam_nhuan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println(" Enter the year: ");
        year = scanner.nextInt();
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                System.out.printf(" %d is a leap year", year);
            } else System.out.printf(" %d is NOT a leap year ", year);
        } else {
            if (year % 4 == 0) System.out.printf(" %d is a leap year", year);
            else System.out.printf("%d is NOT a leap year", year);
        }
    }
}
