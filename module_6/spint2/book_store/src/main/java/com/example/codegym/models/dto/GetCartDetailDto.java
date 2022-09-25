package com.example.codegym.models.dto;

import java.math.BigDecimal;

public interface GetCartDetailDto {
    Integer getAmount();
    int getQuantity();
    String getName();
    String getImage_url();
    Integer getUnit_price();
    Long getId();
    Long getCd_id();
    Long getCart_id();
}
