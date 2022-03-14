package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh.bai_6_ung_dung_dem_so_luong_sinh_vien_thi_do;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("nhập số lượng sinh viên cần nhập điểm:");
            size = scanner.nextInt();

            if (size > 30) {
                System.out.println("không được nhập quá 30 sinh viên");
            }
        } while (size > 30);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("nhập điểm cho sinh viên thứ " + (i + 1));
            array[i] = scanner.nextInt();
        }
        System.out.println("danh sách điểm thi:");
        int count = 0;
        for (int element : array) {
            System.out.print(element + "\t");
            if (element >= 5 && element <= 10) {
                count++;
            }
        }
        System.out.println("số lượng sinh viên đỗ :" + count);
    }
}
