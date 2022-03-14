package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_5_tim_gia_tri_nho_nhat_trong_mang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int findMinArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập kích thước của mảng:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("nhập giá trị cho mảng:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Array[" + i + "]=");
            array[i] = scanner.nextInt();
        }
        System.out.println("mảng bạn đã nhâp " + Arrays.toString(array));
        System.out.println("phần tử có giá trị nhỏ nhất trong mảng là: " + findMinArray(array));
    }
}
