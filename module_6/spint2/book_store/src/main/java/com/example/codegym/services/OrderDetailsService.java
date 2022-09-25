package com.example.codegym.services;

import com.example.codegym.models.dto.OrderDetailDTO;
import com.example.codegym.models.entity.OrderDetail;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailDTO save(OrderDetailDTO orderDetailDTO);

    List<OrderDetailDTO> getAllByOrderId(Long id);
   List<OrderDetail> addToOrderDetail(Long cartId);
}
