package com.example.demo.service;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    void save(Contract contract);
    List<Contract> getAll();
}
