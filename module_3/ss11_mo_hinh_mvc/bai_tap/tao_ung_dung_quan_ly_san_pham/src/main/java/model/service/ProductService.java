package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    List<Product> findByName(String name);
    Product findById(int id);
    void remove(int id);
    void update ( Product product);
}
