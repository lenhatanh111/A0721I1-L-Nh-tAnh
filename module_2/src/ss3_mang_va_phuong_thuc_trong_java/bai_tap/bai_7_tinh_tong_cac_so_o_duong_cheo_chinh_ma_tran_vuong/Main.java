package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_7_tinh_tong_cac_so_o_duong_cheo_chinh_ma_tran_vuong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập kích thước của ma trận vuông row*column (row=column)");
        int size = scanner.nextInt();
        double sum = 0;
        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("array[" + i + "][" + j + "]=");
                array[i][j] = scanner.nextDouble();
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("mảng bạn vừa nhập");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("array[" + i + "][" + j + "]=" + array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("tổng các số ở đường chéo chính của ma trận là:" + sum);
    }
}
