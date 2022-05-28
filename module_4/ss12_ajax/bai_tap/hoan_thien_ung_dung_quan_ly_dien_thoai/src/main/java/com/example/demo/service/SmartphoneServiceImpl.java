package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository repository;
    @Override
    public List<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return repository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
repository.deleteById(id);
    }

    @Override
    public Optional<Smartphone> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Smartphone smartphone) {
        repository.save(smartphone);
    }
}
