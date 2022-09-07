package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getAll();
}
