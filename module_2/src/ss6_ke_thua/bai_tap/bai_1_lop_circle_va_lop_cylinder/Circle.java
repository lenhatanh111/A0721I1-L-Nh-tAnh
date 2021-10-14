package ss6_ke_thua.bai_tap.bai_1_lop_circle_va_lop_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double area(){
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "radius= "+radius+","+"color= "+color+","+"Area= "+area();
    }
}
