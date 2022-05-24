package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping_cart")
    public String showCart (@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "/cart";
    }

}
