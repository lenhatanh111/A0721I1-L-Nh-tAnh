package com.example.codegym.controllers;

import com.example.codegym.models.dto.CartDTO;
import com.example.codegym.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("user/{id}")
    public List<CartDTO> getById(@PathVariable(value = "id") long id) {
        return cartService.findByUserId(id);
    }

}
