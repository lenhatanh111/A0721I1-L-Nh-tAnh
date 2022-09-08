package com.example.codegym.services;

import com.example.codegym.models.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> findByUserId(Long id);
}
