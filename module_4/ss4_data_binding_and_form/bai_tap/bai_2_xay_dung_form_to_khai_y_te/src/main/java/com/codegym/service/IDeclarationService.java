package com.codegym.service;

import com.codegym.entity.Declaration;

import java.util.List;

public interface IDeclarationService {
    List<Declaration> findAll();
    void create(Declaration declaration);
    void update(Declaration declaration);
    Declaration findByID(String id);
}
