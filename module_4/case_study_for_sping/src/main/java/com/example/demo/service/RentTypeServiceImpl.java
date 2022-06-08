package com.example.demo.service;

import com.example.demo.model.RentType;
import com.example.demo.repository.RentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService{
    @Autowired
    private RentTypeRepository repository;
    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
