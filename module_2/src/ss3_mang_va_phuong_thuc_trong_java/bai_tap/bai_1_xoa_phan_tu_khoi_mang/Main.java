package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_1_xoa_phan_tu_khoi_mang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 5, 3, 7, 9, 2, 12, 4, 3};
        boolean check;
        int index = 0;
        System.out.println(" Nhập phần tử bạn muốn xóa!");
        System.out.println("Mảng ban đầu: " + Arrays.toString(array));
        do {
            int deleteElement = scanner.nextInt();
            check = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == deleteElement) {
                    index = i;
                    check = true;
                    deleteArray(array, index);
                }
            }
            if (!check) {
                System.out.println("không tìm thấy phần tử trong mảng, xin mời nhập lại!");
            }

        } while (!check);
        System.out.println("Mảng sau khi xóa: " + Arrays.toString(array));

    }

    public static int[] deleteArray(int[] array, int index) {
        int temp;
        for (int j = index; j < array.length - 1; j++) {
            temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
        array[array.length - 1] = 0;
        return array;
    }
}

