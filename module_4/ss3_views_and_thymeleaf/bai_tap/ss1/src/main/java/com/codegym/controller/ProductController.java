package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
private IProductService service;
    @GetMapping("")
    public String index(Model model) {

        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @GetMapping("/create")
    private String createForm(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    private String save(@ModelAttribute("product") Product product){
        service.create(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String update(Product product) {
        service.update(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        service.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "/view";
    }
}
