package com.codegym.repository;

import com.codegym.entity.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Declaration> findAll();
    void create(Declaration declaration);
    void update(Declaration declaration);
    Declaration findByID(String id);
}
