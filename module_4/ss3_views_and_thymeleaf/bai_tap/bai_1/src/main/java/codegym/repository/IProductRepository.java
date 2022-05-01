package codegym.repository;

import codegym.entity.Product;

import java.util.List;

public interface IProductRepository {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    List<Product> findAll();
    Product findById(String id);
    Product findByName(String name);

}
