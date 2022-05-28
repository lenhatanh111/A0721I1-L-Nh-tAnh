package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
    Optional<Smartphone> getById(Long id);
    void update(Smartphone smartphone);

}
