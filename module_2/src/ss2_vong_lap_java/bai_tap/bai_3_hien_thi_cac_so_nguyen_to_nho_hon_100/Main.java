package ss2_vong_lap_java.bai_tap.bai_3_hien_thi_cac_so_nguyen_to_nho_hon_100;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(i + ",");
            }
        }
        System.out.println("are prime numbers!!!");
    }
}
