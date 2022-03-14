package ss2_vong_lap_java.bai_tap.bai_2_hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in: ");
        int numbers=scanner.nextInt();
        int count=0;

        int num=2;
        while (count<numbers){
            boolean check=true;
            for (int i=2;i<=Math.sqrt(num);i++){
                if (num%i==0) {
                    check = false;
                    break;
                }
            }
            if (check){
                count++;
                System.out.print(num+",");
            }
            num++;
        }
        System.out.println("are prime numbers!!!");
    }
}
