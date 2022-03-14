package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_6_tính_tong_cac_so_o_1_cot_xac_dinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập số dòng: ");
        int row=scanner.nextInt();
        System.out.println("nhập số cột: ");
        int col=scanner.nextInt();
        double [][]array=new double[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.println("Array["+i+"]["+j+"]=");
                array[i][j]=scanner.nextDouble();
            }
        }
        System.out.println("mảng vừa nhập: ");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print("Array["+i+"]["+j+"]="+array[i][j]+"\t");
            }
            System.out.print("\n");
        }
        findMaxColumn(array,row,col);

    }
    public static void findMaxColumn(double [][]array,int row,int col){
        Scanner scanner=new Scanner(System.in);
        int column;
        do {
            System.out.println("nhập cột bạn muốn tính tổng:");
            column=scanner.nextInt();
            if (column<0 || column>col){
                System.out.println("nhập sai!!");
            }
        }while (column<0 || column>col);
        double sum=0;
        for (int i=0;i<row;i++){
                sum+=array[i][column];
        }
        System.out.println("tổng các số ở cột thứ "+column+" là: "+sum);
    }

}
