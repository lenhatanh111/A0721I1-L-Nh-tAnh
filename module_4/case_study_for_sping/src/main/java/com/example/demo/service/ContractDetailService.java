package com.example.demo.service;

import com.example.demo.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
    void save(ContractDetail contractDetail);
    List<ContractDetail> getAll();
}
