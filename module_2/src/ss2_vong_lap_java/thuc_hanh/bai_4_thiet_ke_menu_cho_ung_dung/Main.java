package ss2_vong_lap_java.thuc_hanh.bai_4_thiet_ke_menu_cho_ung_dung;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choose=-1;
        while (choose!=0){
            System.out.println("MENU\n" +
                    "1.vẽ hình tam giác\n" +
                    "2.vẽ hình vuông\n" +
                    "3.vẽ hình chữ nhật\n" +
                    "0.Thoát\n" +
                    "Nhập sự lựa chọn của bạn!!!");
            choose=scanner.nextInt();
            switch (choose){
                case 1:
                    for (int i=0;i<5;i++){
                        for (int j=0;j<i+1;j++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    for (int i=0;i<5;i++){
                        System.out.print("*   *   *   *   *\n");
                    }
                    break;
                case 3:
                    for (int i=0;i<4;i++){
                        System.out.print("*    *    *    *    *\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("bạn chọn sai vui lòng chọn lại!!!");
            }
        }
    }
}
