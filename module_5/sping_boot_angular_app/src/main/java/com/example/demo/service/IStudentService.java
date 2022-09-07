package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Page<Student> getAll(Pageable pageable);
void save(Student student);
void delete(int id);
Student findById(int id);
List<Student> findAll();
//Optional<Student> getById(int id);
}
