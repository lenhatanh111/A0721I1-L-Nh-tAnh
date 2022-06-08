package com.example.demo.service;

import com.example.demo.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachServiceService{
    List<AttachService> findAll();
}
