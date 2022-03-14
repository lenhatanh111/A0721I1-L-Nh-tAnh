package ss2_vong_lap_java.thuc_hanh.bai_1_hien_thi_so_nguyen_to;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập số nguyên dương cần kiểm tra: ");
        int number= scanner.nextInt();
        boolean check = true;
        if (number<2){
            check= false;
        }else {
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number%i==0){
                    check= false;
                    break;
                }

            }
        }
        if (check){
            System.out.println(number+" is a prime");
        }else {
            System.out.println(number+" is NOT a prime");
        }
    }
}
