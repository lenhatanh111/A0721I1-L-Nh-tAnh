package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        return repository.getProductById(id);
    }

    @Override
    public Boolean checkId(int id) {
        return repository.existsById(id);
    }

    @Override
    public void addProduct(Product product) {
        repository.save(product);
    }
}
