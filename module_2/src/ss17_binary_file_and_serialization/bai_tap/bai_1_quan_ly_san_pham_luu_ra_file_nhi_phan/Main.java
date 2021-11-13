package ss17_binary_file_and_serialization.bai_tap.bai_1_quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int choice = 0;
        while (choice != 4) {
            System.out.println("1.Hiển thị thông tin sản phẩm \n" +
                    "2.Thêm sản phẩm \n" +
                    "3.Tìm kiếm sản phẩm theo giá \n" +
                    "4.Thoát");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hiển thị thông tin sản phẩm");
                    productManager.display();
                    break;
                case 2:
                    System.out.println("Thêm sản phẩm");
                    productManager.add();
                    break;
                case 3:
                    System.out.println("Tìm kiếm sản phẩm theo giá");
                    productManager.search();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
