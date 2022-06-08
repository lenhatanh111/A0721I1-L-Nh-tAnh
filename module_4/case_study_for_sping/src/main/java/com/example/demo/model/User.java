package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String name;
    private String password;
    @OneToMany(mappedBy = "user")
    List<UserRole> userRoles;
    @OneToMany(mappedBy = "user")
    List<Employee> employees;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
