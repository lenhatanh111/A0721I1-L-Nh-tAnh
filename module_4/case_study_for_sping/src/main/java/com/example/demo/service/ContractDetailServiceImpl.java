package com.example.demo.service;

import com.example.demo.model.ContractDetail;
import com.example.demo.repository.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository repository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
repository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> getAll() {
        return repository.findAll();
    }
}
