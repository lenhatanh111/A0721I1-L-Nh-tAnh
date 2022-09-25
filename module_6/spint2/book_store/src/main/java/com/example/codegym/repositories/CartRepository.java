package com.example.codegym.repositories;

import com.example.codegym.models.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

Cart getCartById(Long id);
    List<Cart>findByUserId(Long id);
}
