package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_3_gop_mang;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] array3 = new int[array1.length + array2.length];
        System.out.println("nhập giá trị cho mảng 1:");
        for (int i = 0; i < array1.length; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            array1[i] = scanner.nextInt();
        }
        System.out.println("nhập giá trị cho mảng 2:");
        for (int i = 0; i < array2.length; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            array2[i] = scanner.nextInt();
        }
        System.out.println("mảng bạn đã nhập:");
        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            array3[j + array1.length] = array2[j];
        }
        System.out.println("mảng sau khi gộp: Array3: " + Arrays.toString(array3));
    }
}
