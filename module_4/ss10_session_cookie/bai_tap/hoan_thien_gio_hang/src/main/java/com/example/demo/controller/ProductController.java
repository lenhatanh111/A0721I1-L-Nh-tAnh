package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products",productService.findAll());
        return "/shop";
    }

    @GetMapping("/{id}/add")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart) {
       Product product = productService.findById(id);
        if (!productService.checkId(id)) {
            return "/error.404";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
    @GetMapping("/{id}/detail")
    public String viewProductDetail(@PathVariable Integer id, Model model){
       Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }
    @GetMapping("/{id}/increase")
    public String increase(@PathVariable Integer id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        cart.addProduct(product);
        return "redirect:/shopping_cart";
    }
    @GetMapping("/{id}/decrease")
    public String decrease(@PathVariable Integer id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        cart.minusProduct(product);
        return "redirect:/shopping_cart";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id,@ModelAttribute Cart cart){
        Product product = productService.findById(id);
       cart.delete(product);
        return "redirect:/shopping_cart";
    }

}
