package ss11_stack_queu.bai_tap.bai_6_to_chuc_du_lieu_hop_ly_demerging_su_dung_queu;

public class Employee {
    public String name;
    public int age;
    public int birthDay;
    public String gender;

    public Employee() {
    }

    public Employee(String name, int age, int birthDay, String gender) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\''
                ;
    }
}
