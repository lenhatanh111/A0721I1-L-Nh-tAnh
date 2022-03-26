package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList =new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if (product.getName().equals(name)) {
                productList.add(product);
            }

        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {
productRepository.remove(id);
    }

    @Override
    public void update(Product product) {
productRepository.update(product);
    }
}
