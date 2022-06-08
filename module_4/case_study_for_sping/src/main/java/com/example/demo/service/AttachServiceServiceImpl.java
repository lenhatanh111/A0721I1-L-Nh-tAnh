package com.example.demo.service;

import com.example.demo.model.AttachService;
import com.example.demo.repository.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService{
    @Autowired
    private AttachServiceRepository repository;
    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }
}
