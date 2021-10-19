package ss6_ke_thua.bai_tap.bai_5_chuong_trinh_quan_li_hoc_sinh.model;

public class Student extends Person {
    private int point;
    private String subject;

    public Student() {

    }

    public Student(int id, String name, int age, String address, int point, String subject) {
        super(id, name, age, address);
        this.point = point;
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "point=" + point +
                ", subject='" + subject + '\'';
    }
}
