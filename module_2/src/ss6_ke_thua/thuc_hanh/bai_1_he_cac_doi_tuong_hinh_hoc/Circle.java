package ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc;
import ss7_abstract_class_and_interface.bai_tap.bai_1_trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                +"area= "
                +getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius+=this.radius*percent/100;
    }
}
