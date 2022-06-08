package com.example.demo.repository;

import com.example.demo.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
