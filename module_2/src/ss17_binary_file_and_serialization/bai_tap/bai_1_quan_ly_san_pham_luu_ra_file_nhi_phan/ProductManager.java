package ss17_binary_file_and_serialization.bai_tap.bai_1_quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
private static  ReadAndWriteObject readAndWriteObject = new ReadAndWriteObject();
private static Scanner scanner = new Scanner(System.in);
    public static void add() {
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("nhập hãng sản xuất");
        String manufacturer = scanner.nextLine();
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(id, name, price, manufacturer));
        readAndWriteObject.writeObject(products);

    }

    public static void display() {
        ArrayList<Product> list = readAndWriteObject.readObject();
        for (Product products : list) {
            System.out.println(products.toString());
        }
    }

    public static void search() {
        System.out.println("nhập giá bạn muốn tìm");
        double price = scanner.nextDouble();
        ArrayList<Product> list = readAndWriteObject.readObject();
        boolean check = false;
        for (Product products : list) {
            if (products.getPrice() == price) {
                check = true;
                System.out.println(products);
            }
        }
        if (!check) {
            System.out.println("không tìm thấy sản phẩm");
        }
    }
}
