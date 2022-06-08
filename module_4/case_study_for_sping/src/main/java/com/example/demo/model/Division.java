package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String divisionName;
    @OneToMany(mappedBy = "division")
    List<Employee> emloyees;

    public Division() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmloyees() {
        return emloyees;
    }

    public void setEmloyees(List<Employee> emloyees) {
        this.emloyees = emloyees;
    }
}
