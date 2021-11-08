package ss12_java_colection_framework.bai_tap.bai_1_luyen_tap_su_dung_arraylist_linkedlist_trong_java_colection;

import java.util.Comparator;

public class Product {
   private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", price=" + price
                ;
    }

//    @Override
//    public int compareTo(Product product) {
//        return this.getPrice() - product.getPrice();
//    }
}
