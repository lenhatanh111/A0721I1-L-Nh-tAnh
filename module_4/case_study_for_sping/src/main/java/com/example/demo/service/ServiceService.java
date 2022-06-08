package com.example.demo.service;

import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    void save(Service service);
    Page<Service> findAll(Pageable pageable);
    List<Service> getAll();
}
