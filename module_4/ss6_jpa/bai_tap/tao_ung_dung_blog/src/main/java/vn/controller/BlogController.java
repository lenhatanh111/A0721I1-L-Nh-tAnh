package vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.entity.Blog;
import vn.service.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService service;
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("blogs",service.getList());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        service.create(blog);
        return "redirect:/blog";
    }
    @GetMapping("/{blogId}/update")
    public String showEditForm(@PathVariable int blogId,Model model){
model.addAttribute("blog",service.findById(blogId));
return "/update";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        service.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/{blogId}/view")
    public String view(@PathVariable int blogId,Model model){
        model.addAttribute("blog",service.findById(blogId));
        return "/view";
    }
    @GetMapping("/{blogId}/delete")
    public String showDeleteForm(@PathVariable int blogId,Model model){
        model.addAttribute("blog",service.findById(blogId));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Blog blog){
service.delete(blog.getBlogId());
        return "redirect:/blog";
    }

}
