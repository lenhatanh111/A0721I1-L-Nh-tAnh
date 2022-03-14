package ss12_java_colection_framework.bai_tap.bai_1_luyen_tap_su_dung_arraylist_linkedlist_trong_java_colection;

import java.util.Comparator;

public class sortProduct implements Comparator<Product> {
    @Override
    public int compare(Product product, Product t1) {
        return t1.getPrice() - product.getPrice();
    }
}
