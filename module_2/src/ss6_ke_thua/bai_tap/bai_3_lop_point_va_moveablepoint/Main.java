package ss6_ke_thua.bai_tap.bai_3_lop_point_va_moveablepoint;

public class Main {
    public static void main(String[] args) {
        Point point=new Point(1,2);
        System.out.println(point);
        MovablePoint movablePoint=new MovablePoint(1,2,3,4);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());

    }
}
