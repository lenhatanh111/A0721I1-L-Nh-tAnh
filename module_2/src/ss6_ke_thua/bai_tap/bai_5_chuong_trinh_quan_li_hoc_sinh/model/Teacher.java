package ss6_ke_thua.bai_tap.bai_5_chuong_trinh_quan_li_hoc_sinh.model;

public class Teacher extends Person {
    private float salary;
    public Teacher(){

    }
    public Teacher(int id, String name, int age, String address, float salary) {
        super(id, name, age, address);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
