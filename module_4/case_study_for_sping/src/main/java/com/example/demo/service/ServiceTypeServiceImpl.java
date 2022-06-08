package com.example.demo.service;

import com.example.demo.model.ServiceType;
import com.example.demo.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService{
    @Autowired
    private ServiceTypeRepository repository;
    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }
}
