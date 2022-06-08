package com.example.demo.service;

import com.example.demo.model.CustomerType;
import com.example.demo.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService{
    @Autowired
    private CustomerTypeRepository repository;
    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
