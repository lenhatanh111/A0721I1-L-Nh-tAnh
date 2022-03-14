package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh.bai_3_tim_gia_tri_lon_nhat_trong_mang;

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
        int max=array[0];
        int index=0;
        for (int i=1;i<array.length;i++){
            if (array[i]>max){
                max=array[i];
                index=i;
            }
        }
        System.out.println("phần tử lớn nhất trong mảng là: "+max+" ở vị trí thứ :"+(index+1));
    }
}
