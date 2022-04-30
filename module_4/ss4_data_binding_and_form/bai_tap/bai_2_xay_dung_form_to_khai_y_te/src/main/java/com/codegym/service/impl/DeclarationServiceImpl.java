package com.codegym.service.impl;

import com.codegym.entity.Declaration;
import com.codegym.repository.IDeclarationRepository;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeclarationServiceImpl implements IDeclarationService {
    @Autowired
    private IDeclarationRepository repository;

    @Override
    public List<Declaration> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Declaration declaration) {
        repository.create(declaration);
    }

    @Override
    public void update(Declaration declaration) {
        repository.update(declaration);
    }

    @Override
    public Declaration findByID(String id) {
        return repository.findByID(id);
    }
}
