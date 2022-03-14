package mobile_manage;

import ss17_binary_file_and_serialization.bai_tap.bai_1_quan_ly_san_pham_luu_ra_file_nhi_phan.ReadAndWriteObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TienIch {
    private static DocGhiFileCSV docGhiFileCSV=new DocGhiFileCSV();
    private static Scanner scanner = new Scanner(System.in);
private static List<E> mobile=new ArrayList<>();
    public static void add1(){

        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("nhap so luong");
        int nums=Integer.parseInt(scanner.nextLine());
        System.out.println("nhập hãng sản xuất");
        String product = scanner.nextLine();
        System.out.println("thoi gian bao hanh");
       double warrantyPeriod=Double.parseDouble(scanner.nextLine());
        System.out.println("pham vi bao hanh");
        String warrantyCoverage=scanner.nextLine();
        DienThoaiChinhHang dienThoaiChinhHang=new DienThoaiChinhHang(id,name,price,nums, product,price,warrantyPeriod,warrantyCoverage);
        mobile.add(dienThoaiChinhHang);
        docGhiFileCSV.write();

    }
}
