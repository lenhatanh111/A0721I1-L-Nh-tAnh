package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
//    void save( Blog blog);
//
//    void edit(Blog blog);
//    Blog findById(Long id);
//    void delete(Long id);
//
//    Page<Blog> getAllBlog(String author, String category, Pageable pageable );
    List<Category> getAllCategory();
}
