package ss7_abstract_class_and_interface.bai_tap.bai_2_trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Circle;
import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Rectangle;
import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Shape;
import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(2, 3);
        shapes[2] = new Square(4);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println(((Square) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());
            }
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
