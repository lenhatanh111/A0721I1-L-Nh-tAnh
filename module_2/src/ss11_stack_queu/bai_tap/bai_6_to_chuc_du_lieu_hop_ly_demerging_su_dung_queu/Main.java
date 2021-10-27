package ss11_stack_queu.bai_tap.bai_6_to_chuc_du_lieu_hop_ly_demerging_su_dung_queu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Employee> nam = new LinkedList<>();
        Queue<Employee> nu = new LinkedList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("anh", 21, 28, "nam"));
        employees.add(new Employee("em", 21, 28, "nu"));
        employees.add(new Employee("loan", 21, 28, "nu"));
        employees.add(new Employee("thanh", 21, 28, "nam"));
        employees.add(new Employee("oanh", 21, 28, "nu"));
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.gender.equals("nam")) {
                nam.add(employee);
            } else if (employee.gender.equals("nu")) {
                nu.add(employee);
            }
        }
        while (!nu.isEmpty()) {
            result.add(nu.poll());
        }
        while (!nam.isEmpty()) {
            result.add(nam.poll());
        }
        System.out.println("dữ liệu sau khi sắp xếp");
        for (Employee employee : result) {
            System.out.println(employee.toString());
        }

    }
}
