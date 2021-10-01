package ss1_introduction_to_java.thuc_hanh.bai_7_tinh_chi_so_can_nang_co_the;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        String name;
        System.out.println(" enter your name: ");
        name = scanner.nextLine();
        System.out.print("Your weight (in kilogram):");
        weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Your height (in meter):");
        height = Double.parseDouble(scanner.nextLine());
        bmi = weight / Math.pow(height, 2);
        System.out.println("Name: " + name);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");

    }
}
