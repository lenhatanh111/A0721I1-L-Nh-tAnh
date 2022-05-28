package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    void save( Blog blog);

//    void edit(Blog blog);
    Blog findById(Long id);
    void delete(Long id);

    Page<Blog> getAllBlog(String author, String category, Pageable pageable );
//    Page<Blog> getAllBlogSortByReleaseDate(Pageable pageable);
    List<Blog> findAllBlog();
    Optional<Blog>getById(Long id);
    List<Blog> findByAuthor(String name);

}
