package ss6_ke_thua.bai_tap.bai_2_lop_point_2d_va_lop_point_3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point2D=new Point2D(2,3);
        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.println(point2D);
        Point3D point3D=new Point3D(1,2,3);
        System.out.println(point3D);
    }
}
