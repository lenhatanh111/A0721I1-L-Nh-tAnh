package ss12_java_colection_framework.thuc_hanh.bai_3_sap_xep_voi_comparable_va_comparator;

import ss12_java_colection_framework.thuc_hanh.bai_2_phan_biet_hashmap_va_hashset.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}
