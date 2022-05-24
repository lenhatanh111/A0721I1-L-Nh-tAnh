package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class NewCart {
    List<Product> products=new ArrayList<>();

    public NewCart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    private boolean checkItemInCart(Product product){
        for (Product p: products) {
            if (p.getId()==(product.getId())){
                return true;
            }
        }
        return false;
    }
    public void addProduct(Product product){

    }
}
