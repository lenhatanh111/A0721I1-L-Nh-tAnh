package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository{
    private static Map<String,Product> productMap=new HashMap<>();
    static {
        productMap.put("P-001",new Product("P-001","iphone 14pro","2000$","chinh hang","apple"));
        productMap.put("P-002",new Product("P-002","samsung S21 ultra","3000$","chinh hang","samsung"));
        productMap.put("P-003",new Product("P-003","iphone 14pro","2000$","chinh hang","apple"));
        productMap.put("P-004",new Product("P-004","iphone 14pro","2000$","chinh hang","apple"));
        productMap.put("P-005",new Product("P-005","iphone 14pro","2000$","chinh hang","apple"));
        productMap.put("P-006",new Product("P-006","iphone 14pro","2000$","chinh hang","apple"));
    }

    @Override
    public void create(Product product) {
        if(!productMap.containsKey(product.getId())){
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void update(Product product) {
        if(productMap.containsKey(product.getId())){
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void delete(String id) {
        if(productMap.containsKey(id)){
            productMap.remove(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public Product findByName(String name) {
        Product product=null;
        for (Product p : productMap.values()) {
            if (p.getName().equals(name)){
               product=p;
            }
        }
        return product;
    }
}
