package ss2_vong_lap_java.thuc_hanh.bai_2_ung_dung_tinh_tien_lai_cho_vay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println(" nhập lãi suất ngân hàng (%/năm): ");
        double interestRate= scanner.nextDouble();
        System.out.println(" nhập số tiền bạn gửi (triệu VND): ");
        double deposits=scanner.nextDouble();
        System.out.println(" nhập số tháng bạn gửi: ");
        int month=scanner.nextInt();
        double interest= deposits*((interestRate/100)/12)*month;
        System.out.println("Số tiền lãi bạn nhận được sau "+month+" tháng là: "+interest+ " triệu VND");

    }
}
