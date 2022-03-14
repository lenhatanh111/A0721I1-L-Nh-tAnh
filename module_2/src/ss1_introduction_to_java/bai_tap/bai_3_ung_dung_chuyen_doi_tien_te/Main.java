package ss1_introduction_to_java.bai_tap.bai_3_ung_dung_chuyen_doi_tien_te;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        int usd, vnd;
        System.out.println("nhập số tiền cần chuyển đổi (usd->vnd) ");
        usd = scanner.nextInt();
        vnd = usd * rate;
        System.out.println(usd + " USD đổi được " + vnd + " VND");
    }
}
