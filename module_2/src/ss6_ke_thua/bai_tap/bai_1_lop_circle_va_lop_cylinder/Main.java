package ss6_ke_thua.bai_tap.bai_1_lop_circle_va_lop_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle=new Circle(2.0,"red");
        System.out.println(circle);
//        Cylinder cylinder=new Cylinder(4.0,"green",2.0);
        circle=new Cylinder(9,"yellow",3);
        System.out.println(circle);
    }
}
