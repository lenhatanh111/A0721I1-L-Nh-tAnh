package ss2_vong_lap_java.bai_tap.bai_1_hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("MENU\n" +
                    "1.Print the rectangle\n" +
                    "2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)\n" +
                    "3.Print isosceles triangle\n" +
                    "0.Exit\n" +
                    "Enter your choice!!!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the width:");
                    int width = scanner.nextInt();
                    System.out.println("Enter the height");
                    int height = scanner.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("*   ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("choice the corner:\n" +
                            "1.botton_left\n" +
                            "2.top_left\n" +
                            "3.botton_right\n" +
                            "4.top_right\n" +
                            "Enter the choice!!!");
                    int choose = scanner.nextInt();
                    System.out.println(" Enter the height: ");
                    int heightTriangle = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            for (int i = 0; i < heightTriangle; i++) {
                                for (int j = 0; j < i + 1; j++) {
                                    System.out.print(" *");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            for (int i = 0; i < heightTriangle; i++) {
                                for (int j = heightTriangle - 1; j >= i; j--) {
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 3:
                            for (int i = 0; i < heightTriangle; i++) {
                                for (int j = heightTriangle - 1; j >= i; j--) {
                                    System.out.print("  ");
                                }
                                for (int k = 0; k <= i; k++) {
                                    System.out.print(" *");
                                }
                                System.out.print("\n");
                            }

                            break;
                        case 4:
                            for (int i = 0; i < heightTriangle; i++) {
                                for (int j = 0; j < i + 1; j++) {
                                    System.out.print("  ");
                                }
                                for (int k = heightTriangle - 1; k >= i; k--) {
                                    System.out.print(" *");
                                }
                                System.out.print("\n");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println(" Enter the height of isosceles triangle");
                    int height1 = scanner.nextInt();
                    for (int i = 0; i < height1; i++) {
                        for (int j = height1 - 1; j >= i; j--) {
                            System.out.print("  ");
                        }
                        for (int k = 0; k < 2 * i + 1; k++) {
                            System.out.print(" *");
                        }
                        System.out.print("\n");
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
