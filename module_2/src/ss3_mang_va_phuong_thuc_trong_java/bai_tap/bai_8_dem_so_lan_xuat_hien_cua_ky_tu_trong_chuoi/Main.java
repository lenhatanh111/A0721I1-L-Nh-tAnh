package ss3_mang_va_phuong_thuc_trong_java.bai_tap.bai_8_dem_so_lan_xuat_hien_cua_ky_tu_trong_chuoi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "lenhatanh";
        System.out.println("nhập ký tự bạn muốn đếm");
        String inputCharacter = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == inputCharacter.charAt(0)) {
                count++;
            }
        }
        System.out.println("ký tự " + inputCharacter + " xuất hiện trong chuỗi " + str + ":" + count + " lần");
    }
}
