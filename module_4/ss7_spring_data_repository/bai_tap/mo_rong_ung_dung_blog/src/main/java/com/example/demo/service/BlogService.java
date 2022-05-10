package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            blogRepository.delete(blog);
        }
    }


    @Override
    public Page<Blog> getAllBlog(String author, String category, Pageable pageable) {
        return blogRepository.findAll(author, category, pageable);
    }

    @Override
    public Page<Blog> getAllBlogSortByReleaseDate(Pageable pageable) {
        return blogRepository.sortByReleaseDate(pageable);
    }

//    @Override
//    public Page<Blog> getAllBlog(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }
}
