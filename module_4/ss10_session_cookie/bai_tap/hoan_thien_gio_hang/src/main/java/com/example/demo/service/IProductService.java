package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
   List<Product> findAll();
    Product findById(int id);
    Boolean checkId(int id);
    void addProduct(Product product);
}
