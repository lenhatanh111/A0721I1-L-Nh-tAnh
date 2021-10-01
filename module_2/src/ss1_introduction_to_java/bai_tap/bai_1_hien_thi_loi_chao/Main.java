package ss1_introduction_to_java.bai_tap.bai_1_hien_thi_loi_chao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.printf("Hello: %s", name);
    }
}
