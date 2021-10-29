package ss12_java_colection_framework.bai_tap.bai_1_luyen_tap_su_dung_arraylist_linkedlist_trong_java_colection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.add(new Product(1, "iphone 3", 300));
        productManager.add(new Product(2, "iphone 4", 600));
        productManager.add(new Product(3, "iphone 5", 100));
        productManager.add(new Product(4, "iphone 6", 200));
        productManager.add(new Product(5, "iphone 7", 900));
//        productManager.edit(003);
        System.out.println("tăng dần");
        productManager.sortUpAscending();

        System.out.println("giảm dần");
        productManager.sortDescending();

        System.out.println("xóa");
        productManager.delete(4);


    }
}
