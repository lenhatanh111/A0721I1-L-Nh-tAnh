package codegym.service;

import codegym.entity.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    List<Product> findAll();
    Product findById(String id);
    Product findByName(String name);
}
