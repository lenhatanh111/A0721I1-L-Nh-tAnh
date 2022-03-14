package ss5_acess_modifier_static_method_static_property.bai_tap.bai_1_acess_modifier;

public class Circle {
    private double radius=1.0;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    protected double getRadius(){
        return this.radius;
    }
    protected double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }
}
