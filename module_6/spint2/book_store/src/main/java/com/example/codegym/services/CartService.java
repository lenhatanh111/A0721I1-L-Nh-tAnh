package com.example.codegym.services;

import com.example.codegym.models.dto.CartDTO;
import com.example.codegym.models.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findByUserId(Long id);
}
