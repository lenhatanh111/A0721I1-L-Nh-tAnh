package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String positionName;
    @OneToMany(mappedBy = "position")
    List<Employee> emloyees;

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmloyees() {
        return emloyees;
    }

    public void setEmloyees(List<Employee> emloyees) {
        this.emloyees = emloyees;
    }
}
