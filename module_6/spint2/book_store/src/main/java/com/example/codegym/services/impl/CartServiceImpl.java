package com.example.codegym.services.impl;

import com.example.codegym.common.converter.CartConverter;
import com.example.codegym.models.dto.CartDTO;
import com.example.codegym.models.entity.Cart;
import com.example.codegym.repositories.CartRepository;
import com.example.codegym.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartConverter cartConverter;

    @Override
    public List<CartDTO> findByUserId(Long id) {
        List<Cart> carts = cartRepository.findByUserId(id);
        List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
        for (Cart cart : carts) {
            cartDTOs.add(cartConverter.toDTO(cart));
        }
        return cartDTOs;
    }
}
