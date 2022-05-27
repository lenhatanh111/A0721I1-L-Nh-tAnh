package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository repository;
    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }
}
