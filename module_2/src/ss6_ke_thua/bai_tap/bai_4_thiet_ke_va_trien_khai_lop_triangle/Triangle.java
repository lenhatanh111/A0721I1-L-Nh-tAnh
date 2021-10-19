package ss6_ke_thua.bai_tap.bai_4_thiet_ke_va_trien_khai_lop_triangle;

import ss6_ke_thua.thuc_hanh.bai_1_he_cac_doi_tuong_hinh_hoc.Shape;

public class Triangle extends Shape {
    private double side1=1.0;
    private double side2=1.0;
    private double side3=1.0;

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(){}

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }
    public double getArea(){
        return Math.sqrt(getPerimeter()/2*(getPerimeter()/2 -side1)*(getPerimeter()/2 -side2)*(getPerimeter()/2 -side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" +getColor()+
                ", perimeter=" +getPerimeter()+
                ", area=" +getArea()+
                '}';
    }
}
