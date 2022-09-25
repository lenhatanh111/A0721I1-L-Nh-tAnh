package com.example.codegym.services.impl;

import com.example.codegym.common.converter.OrderDetailConverter;
import com.example.codegym.models.dto.OrderDetailDTO;
import com.example.codegym.models.entity.Cart;
import com.example.codegym.models.entity.CartDetail;
import com.example.codegym.models.entity.Order;
import com.example.codegym.models.entity.OrderDetail;
import com.example.codegym.repositories.*;
import com.example.codegym.services.OrderDetailsService;
import com.example.codegym.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailConverter orderDetailConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;

    @Override
    public OrderDetailDTO save(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailRepository.save(orderDetailConverter.toEntity(orderDetailDTO));

        return orderDetailConverter.toDTO(orderDetail);
    }

    @Override
    public List<OrderDetailDTO> getAllByOrderId(Long id) {
        List<OrderDetail> details = orderDetailRepository.findByOrderId(id);
        List<OrderDetailDTO> detailDTOs = new ArrayList<OrderDetailDTO>();
        for (OrderDetail orderDetail : details) {
            detailDTOs.add(orderDetailConverter.toDTO(orderDetail));
        }

        return detailDTOs;
    }

    @Override
    public List<OrderDetail> addToOrderDetail(Long cartId) {
        Cart cart = cartRepository.getCartById(cartId);
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setAmount(cart.getAmount());
        orderRepository.save(order);
        List<CartDetail> cartDetails = cart.getCartDetails();
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartDetail cartDt : cartDetails) {
            orderDetails.add(new OrderDetail(cartDt.getQuantity(), order, cartDt.getProduct()));
            cartDt.setPayed(true);
            cartDetailRepository.save(cartDt);

        }
        order.setOrderDetails(orderDetails);
        orderRepository.save(order);
        cart.setAmount(new BigDecimal(0));
        cartRepository.save(cart);
        return orderDetails;
    }
}
