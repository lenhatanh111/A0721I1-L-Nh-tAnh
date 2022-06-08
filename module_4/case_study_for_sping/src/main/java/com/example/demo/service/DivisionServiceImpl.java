package com.example.demo.service;

import com.example.demo.model.Division;
import com.example.demo.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository repository;
    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }
}
