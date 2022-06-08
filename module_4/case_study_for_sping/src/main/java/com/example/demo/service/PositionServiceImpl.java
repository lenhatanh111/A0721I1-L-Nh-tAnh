package com.example.demo.service;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository repository;
    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }
}
