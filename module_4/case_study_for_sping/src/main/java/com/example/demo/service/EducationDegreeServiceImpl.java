package com.example.demo.service;

import com.example.demo.model.EducationDegree;
import com.example.demo.repository.EducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService{
    @Autowired
    private EducationDegreeRepository repository;
    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
