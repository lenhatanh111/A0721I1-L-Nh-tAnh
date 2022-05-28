package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService service;
   @GetMapping("/getAllBlog")
    public ResponseEntity<Page<Blog>> getAllBlog(Pageable pageable) {
       Page<Blog> blogs=service.getAllBlog("","",pageable);

       if (blogs.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(blogs, HttpStatus.OK);

   }
    @GetMapping("/getBlogByCategory")
    public ResponseEntity<Page<Blog>> getBlogByCategory(@RequestParam(name = "id", required = false) String id,Pageable pageable){
        Page<Blog> blogs= service.getAllBlog("",id,pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}/viewBlogDetail")
    public ResponseEntity<Blog> viewBlogDetail(@PathVariable Long id){

       Optional<Blog> blog=service.getById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
    @GetMapping("/searchAuthor")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> searchTeacher(@RequestParam("name") String name) {
        return service.findByAuthor(name);
    }
}
