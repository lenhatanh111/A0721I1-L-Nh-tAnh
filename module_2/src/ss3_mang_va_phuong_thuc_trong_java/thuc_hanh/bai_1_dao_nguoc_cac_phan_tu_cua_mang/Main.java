package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh.bai_1_dao_nguoc_cac_phan_tu_cua_mang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []array;
        int size;
        do {
            System.out.println("nhập kích thước cho mảng: ");
            size=scanner.nextInt();
            if (size>20){
                System.out.println(" độ dài mảng không được quá 20");
            }
        }while (size>20);
        array= new int[size];
        for (int i=0;i<array.length;i++){
            System.out.println("nhập phần tử thứ "+(i+1)+" cho mảng ");
            array[i]=scanner.nextInt();
        }
        System.out.println("mảng bạn vừa nhâp: \n");
        for (int element : array){
            System.out.print(element+"\t");
        }
        System.out.println("\n");
        int last=array.length-1;
        int temp;
        for (int j=0;j<last;j++){
            temp=array[j];
            array[j]=array[last];
            array[last]=temp;
            last--;
        }
        System.out.println("mảng sau khi đảo ngược: \n");
        for (int element: array){
            System.out.print(element+"\t");
        }
    }
}
