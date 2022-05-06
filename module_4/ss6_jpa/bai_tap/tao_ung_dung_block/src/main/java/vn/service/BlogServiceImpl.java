package vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.entity.Blog;
import vn.repository.IBlogRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;
    @Override
    public void create(Blog blog) {
repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
repository.save(blog);
    }

    @Override
    public void delete(int id) {
        Blog blog = repository.findById(id).orElse(null);
        if (blog != null) {
            repository.delete(blog);
        }
    }

    @Override
    public List<Blog> getList() {
        List<Blog> blogs=new ArrayList<>();
        repository.findAll().forEach(b ->blogs.add(b));
        return blogs;
    }

    @Override
    public Blog findById(int id) {
       return repository.findById(id).orElse(null);

    }
}
