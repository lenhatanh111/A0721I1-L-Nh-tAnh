package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree")
    List<Employee> emloyees;

    public EducationDegree() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }


    public List<Employee> getEmloyees() {
        return emloyees;
    }

    public void setEmloyees(List<Employee> emloyees) {
        this.emloyees = emloyees;
    }
}
