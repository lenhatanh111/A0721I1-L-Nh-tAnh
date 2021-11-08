package ss12_java_colection_framework.bai_tap.bai_1_luyen_tap_su_dung_arraylist_linkedlist_trong_java_colection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public void edit(int id) {
        Scanner scanner = new Scanner(System.in);
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("sửa tên");
                String name = scanner.nextLine();
                product.setName(name);
                System.out.println("sửa giá:");
                int newPrice = scanner.nextInt();
                product.setPrice(newPrice);
            }
            display();
        }
    }

    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
        display();
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void sortUpAscending() {
//        Collections.sort(products);
//        display();
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product product, Product t1) {
//                return product.getPrice()-t1.getPrice();
//            }
//        });
        Collections.sort(products,(Product p1,Product p2)-> p1.getPrice()-p2.getPrice());
        display();

    }

    public void sortDescending() {
        Collections.sort(products, new sortProduct());
        display();
    }


}
