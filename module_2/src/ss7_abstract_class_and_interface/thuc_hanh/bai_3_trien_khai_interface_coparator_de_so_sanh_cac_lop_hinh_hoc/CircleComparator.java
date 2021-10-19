package ss7_abstract_class_and_interface.thuc_hanh.bai_3_trien_khai_interface_coparator_de_so_sanh_cac_lop_hinh_hoc;

import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
