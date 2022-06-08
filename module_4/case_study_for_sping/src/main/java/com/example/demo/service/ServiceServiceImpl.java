package com.example.demo.service;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    private ServiceRepository repository;
    @Override
    public void save(Service service) {
        repository.save(service);
    }
    @Override
    public Page<Service> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
