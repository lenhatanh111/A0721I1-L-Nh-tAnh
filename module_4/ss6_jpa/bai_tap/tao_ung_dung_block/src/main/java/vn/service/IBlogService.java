package vn.service;

import vn.entity.Blog;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    List<Blog> getList();
    Blog findById(int id);
}
