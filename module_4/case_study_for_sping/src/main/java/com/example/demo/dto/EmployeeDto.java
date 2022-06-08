package com.example.demo.dto;

import com.example.demo.model.Division;
import com.example.demo.model.EducationDegree;
import com.example.demo.model.Position;
import com.example.demo.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class EmployeeDto {
    private int id;
    @NotEmpty
    @NotBlank
    private String employeeName;
//    @NotEmpty
//    @NotBlank
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date employeeBirthday;
    @NotEmpty
    @NotBlank
    private String employeeIdCard;
   @Min(0)
    private double employeeSalary;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",message = "sai dinh dang sdt")
    private String employeePhone;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "sai định đạng email")
    private String employeeEmail;
    @NotEmpty
    @NotBlank
    private String employeeAddress;
//    @NotEmpty
//    @NotBlank
    private Division division;
//    @NotEmpty
//    @NotBlank
    private EducationDegree educationDegree;
//    @NotEmpty
//    @NotBlank
    private Position position;
//    @NotEmpty
//    @NotBlank
    private User user;

    public EmployeeDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
