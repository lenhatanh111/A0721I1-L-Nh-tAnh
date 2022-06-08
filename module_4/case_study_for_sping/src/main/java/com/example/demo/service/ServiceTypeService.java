package com.example.demo.service;

import com.example.demo.model.ServiceType;

import java.awt.print.Pageable;
import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
}
