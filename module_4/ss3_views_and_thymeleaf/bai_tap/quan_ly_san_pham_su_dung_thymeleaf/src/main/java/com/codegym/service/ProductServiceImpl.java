package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void update(Product product) {
repository.update(product);
    }

    @Override
    public void delete(String id) {
repository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }
}
