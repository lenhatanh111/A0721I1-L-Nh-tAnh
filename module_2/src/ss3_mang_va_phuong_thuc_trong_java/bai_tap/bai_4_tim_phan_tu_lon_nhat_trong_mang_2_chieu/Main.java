package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_4_tim_phan_tu_lon_nhat_trong_mang_2_chieu;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập sô dòng của ma trận");
        int row = scanner.nextInt();
        System.out.println("nhập số cột của ma trận");
        int column = scanner.nextInt();
        double[][] array = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("nhập phần tử Array[" + i + "][" + j + "]=");
                array[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("mảng bạn đã nhập");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println(" là phần tử lớn nhất trong mảng là :" + findMaxArray(array, row, column));
    }

    public static double findMaxArray(double[][] array, int row, int column) {
        int x = 0, y = 0;
        double max = array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("vị trí: x= " + x + ",y= " + y);
        return max;
    }
}
