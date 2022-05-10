package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categoryList")
    public List<Category> setCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @GetMapping("")
    public String getAllBlog(
            @RequestParam(defaultValue = "") String key_author,
            @RequestParam(defaultValue = "") String key_category
            ,@PageableDefault(size = 2) Pageable pageable
            , Model model) {
        Page<Blog> blogs = iBlogService.getAllBlog(key_author, key_category, pageable);
        model.addAttribute("blogs", blogs);
        model.addAttribute("key_author",key_author);
        model.addAttribute("key_category",key_category);
        return "list" ;
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{blogId}/update")
    public String showEditForm(@PathVariable Long blogId, Model model){
        model.addAttribute("blog",iBlogService.findById(blogId));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        iBlogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{blogId}/view")
    public String view(@PathVariable Long blogId,Model model){
        model.addAttribute("blog",iBlogService.findById(blogId));
        return "/view";
    }
    @GetMapping("/{blogId}/delete")
    public String showDeleteForm(@PathVariable Long blogId,Model model){
        model.addAttribute("blog",iBlogService.findById(blogId));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Blog blog){
        iBlogService.delete(blog.getId());
        return "redirect:/";
    }
    @GetMapping("/sort")
    public String sortByReleaseDate(@PageableDefault(size = 2) Pageable pageable,Model model){
        Page<Blog> blogs=iBlogService.getAllBlogSortByReleaseDate(pageable);
        model.addAttribute("blogs",blogs);
        return "/list";


    }


}
