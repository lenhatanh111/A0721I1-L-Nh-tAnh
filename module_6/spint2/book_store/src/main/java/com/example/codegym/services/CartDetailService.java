package com.example.codegym.services;

import com.example.codegym.models.dto.CartDetailDTO;
import com.example.codegym.models.dto.GetCartDetailDto;
import com.example.codegym.models.dto.TotalDto;
import com.example.codegym.models.entity.Cart;
import com.example.codegym.models.entity.CartDetail;

import java.util.List;

public interface CartDetailService {
    CartDetailDTO save(CartDetailDTO cartDetailDTO);

    CartDetailDTO update(CartDetailDTO cartDetailDTO);

    void delete(Long id);

    List<CartDetailDTO> getByCartId(Long id);

    CartDetailDTO getById(Long id);
    List<Cart> addToCartDetail(Long userId, Long productId);
    List<GetCartDetailDto>getCartDetailByUserId(Long id);
    TotalDto getTotal(Long id);
    List<Cart> setQuantityOfProduct(Long userId, Long productId,Integer quantity);
    CartDetail deleteProductCartDetailId(Long id);
}
