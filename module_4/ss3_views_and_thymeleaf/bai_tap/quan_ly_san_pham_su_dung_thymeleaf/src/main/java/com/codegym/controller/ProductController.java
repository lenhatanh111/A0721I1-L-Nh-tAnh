package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;
    @GetMapping("")
    private String list(Model model){
        List<Product> products=service.findAll();
        model.addAttribute("products",products);
        return "/index";
    }

}
