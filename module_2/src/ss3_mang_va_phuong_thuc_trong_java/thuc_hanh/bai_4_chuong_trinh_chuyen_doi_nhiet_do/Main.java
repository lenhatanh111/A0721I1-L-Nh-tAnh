package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh.bai_4_chuong_trinh_chuyen_doi_nhiet_do;

import java.util.Scanner;

public class Main {
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit=(9.0/5)*celsius+32;
        return fahrenheit;
    }
     public static double fahrenheitToCelsius(double fahrenheit){
        double celsius=(fahrenheit-32)/(9.0/5);
        return celsius;
     }

    public static void main(String[] args) {
        int choice=-1;
        do {
            Scanner scanner=new Scanner(System.in);
            System.out.println("MENU:\n" +
                    "1.Celsius to Fahrenheit\n" +
                    "2.Fahrenheit to celsius\n" +
                    "0.Exit\n" +
                    "Enter your choice!!!");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(" Enter celsius: ");
                    double celsius=scanner.nextInt();
                    System.out.print("Result= "+celsiusToFahrenheit(celsius)+"\n");
                    break;
                case 2:
                    System.out.println(" Enter fahrenheit: ");
                    double fahrenheit=scanner.nextInt();
                    System.out.print("Result= "+fahrenheitToCelsius(fahrenheit)+"\n");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("nhập sai vui lòng nhâp lại!");
            }
        }while (choice!=0);
    }
}
