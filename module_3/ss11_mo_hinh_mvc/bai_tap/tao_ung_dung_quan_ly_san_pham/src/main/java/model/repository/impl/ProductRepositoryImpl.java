package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> products =new ArrayList<>();;
    static {
        products.add(new Product(1,"iphone 6s",4500,"new","apple"));
        products.add(new Product(2,"iphone 7s",6500,"old","apple"));
        products.add(new Product(3,"ipad mini",13000,"new","apple"));
        products.add(new Product(4,"iphone 11",20000,"new","apple"));
        products.add(new Product(5,"iphone 12 pro max",30500,"old","apple"));
        products.add(new Product(6,"samsung s21 ultra ",40000,"new","samsung"));
        products.add(new Product(7,"iphone 7s",8000,"new","apple"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);

    }

    @Override
    public List<Product> findByName(String name) {
       List<Product> productList =new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
               productList.add(product);
            }

        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public void update( Product product) {
        products.add(product);

    }
}
