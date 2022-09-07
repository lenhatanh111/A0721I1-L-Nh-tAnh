package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService{
    @Autowired
    private TeacherRepository repository;

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }
}
