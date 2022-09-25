package com.example.codegym.services.impl;

import com.example.codegym.common.converter.CartDetailConverter;
import com.example.codegym.common.exception.ResourceNotFoundException;
import com.example.codegym.models.dto.CartDetailDTO;
import com.example.codegym.models.dto.GetCartDetailDto;
import com.example.codegym.models.dto.TotalDto;
import com.example.codegym.models.entity.Cart;
import com.example.codegym.models.entity.CartDetail;
import com.example.codegym.models.entity.Product;
import com.example.codegym.models.entity.User;
import com.example.codegym.repositories.CartDetailRepository;
import com.example.codegym.repositories.CartRepository;
import com.example.codegym.repositories.ProductRepository;
import com.example.codegym.repositories.UserRepository;
import com.example.codegym.services.CartDetailService;
import com.example.codegym.services.CartService;
import com.example.codegym.services.ProductService;
import com.example.codegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartDetailRepository cartDetailRepository;

    @Autowired
    CartDetailConverter cartDetailConverter;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public CartDetailDTO save(CartDetailDTO cartDetailDTO) {
        List<CartDetail> cartDetails = cartDetailRepository.findByCartId(cartDetailDTO.getId());

        for (CartDetail cartDetail : cartDetails) {

            if (cartDetail.getProduct().getId() == cartDetailDTO.getProduct().getId()) {
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                CartDetail _cartDetail = cartDetailRepository.save(cartDetail);
                return cartDetailConverter.toDTO(_cartDetail);
            }
        }
        CartDetail _cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

        return cartDetailConverter.toDTO(_cartDetail);
    }

    @Override
    public CartDetailDTO update(CartDetailDTO cartDetailDTO) {
        CartDetail cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

        return cartDetailConverter.toDTO(cartDetail);
    }

    @Override
    public void delete(Long id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public List<CartDetailDTO> getByCartId(Long id) {
        List<CartDetail> cartDetails = cartDetailRepository.findByCartId(id);

        List<CartDetailDTO> cartDetailDTOs = new ArrayList<CartDetailDTO>();

        for (CartDetail cartDetail : cartDetails) {
            cartDetailDTOs.add(cartDetailConverter.toDTO(cartDetail));
        }

        return cartDetailDTOs;
    }

    @Override
    public CartDetailDTO getById(Long id) {
        CartDetail cartDetail = cartDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart detail not found with id :" + id));

        return cartDetailConverter.toDTO(cartDetail);
    }

    @Override
    public List<Cart> addToCartDetail(Long userId, Long productId) {
        boolean check = false;
        List<Cart> carts = cartRepository.findByUserId(userId);
        List<Cart> cartList = new ArrayList<>();
        List<CartDetail> cartDetails = new ArrayList<>();
        if (carts.size() == 0) {
            Cart cart = new Cart(new BigDecimal(1), userRepository.findUserById(userId));
            cartList.add(cart);
            CartDetail cartDetail = new CartDetail(1, false, cart, productRepository.findProductById(productId));
            cartDetailRepository.save(cartDetail);
            cartDetails.add(cartDetail);
            cart.setCartDetails(cartDetails);
            cart.setAmount(cart.getAmount().add(new BigDecimal(1)));
            cartRepository.save(cart);
            return cartList;
        } else {
            for (Cart c : carts) {
                for (CartDetail cd : c.getCartDetails()) {
                    if (cd.getProduct() == null) {
                        cd.setProduct(productRepository.findProductById(productId));
                        cd.setPayed(false);
                        cd.setQuantity(1);
                        cartDetailRepository.save(cd);
                        c.setAmount(c.getAmount().add(new BigDecimal(1)));
                        cartRepository.save(c);
                        check = true;
                        return carts;
                    } else if (cd.getProduct().getId().equals(productId) && !cd.isPayed()) {
                        cd.setQuantity(cd.getQuantity() + 1);
                        cartDetailRepository.save(cd);
                        cartRepository.save(c);
                        check = true;
                        return carts;
                    }
                }
                if (!check) {
                    CartDetail cartDetail = new CartDetail(1, false, c, productRepository.findProductById(productId));
                    c.getCartDetails().add(cartDetail);
                    c.setCartDetails(c.getCartDetails());
                    c.setAmount(c.getAmount().add(new BigDecimal(1)));
                    cartRepository.save(c);
                    return carts;
                }
            }
        }
        return carts;
    }

    @Override
    public List<GetCartDetailDto> getCartDetailByUserId(Long id) {
        return cartDetailRepository.getCartDetailByUserId(id);
    }

    @Override
    public TotalDto getTotal(Long id) {
        List<GetCartDetailDto> cartDetailDtos = cartDetailRepository.getCartDetailByUserId(id);
        long total = 0;
        for (GetCartDetailDto cartDetail : cartDetailDtos) {
            total += cartDetail.getQuantity() * cartDetail.getUnit_price();
        }
        long vat = total * 10 / 100;
        TotalDto totalDto = new TotalDto(total, vat, total + vat);
        return totalDto;
    }

    @Override
    public List<Cart> setQuantityOfProduct(Long userId, Long productId, Integer quantity) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        for (Cart cart : carts) {
            for (CartDetail c : cart.getCartDetails()) {
                if (c.getProduct().getId().equals(productId)) {
                    c.setQuantity(quantity);
                    cartDetailRepository.save(c);
                }
            }

        }
        return carts;
    }

    @Override
    public CartDetail deleteProductCartDetailId(Long id) {
        CartDetail cartDetail = cartDetailRepository.getById(id);
        cartDetail.setProduct(null);
        cartDetailRepository.save(cartDetail);
        List<GetCartDetailDto> cartDetailDtos = cartDetailRepository.getCartDetailByUserId(cartDetail.getCart().getUser().getId());
        cartDetail.getCart().setAmount(new BigDecimal(cartDetailDtos.size()));
        cartDetailRepository.save(cartDetail);
        return cartDetail;
    }


}
