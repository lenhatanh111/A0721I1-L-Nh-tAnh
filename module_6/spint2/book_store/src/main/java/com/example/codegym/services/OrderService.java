package com.example.codegym.services;

import com.example.codegym.models.dto.ChartStatistical;
import com.example.codegym.models.dto.OrderDTO;
import com.example.codegym.models.dto.StatisticByDate;
import com.example.codegym.models.dto.StatisticByProduct;
import com.example.codegym.models.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    OrderDTO update(OrderDTO orderDTO);

    List<Order> getByUserId(Long id);

    OrderDTO getById(Long id);

    Page<OrderDTO> getAll(Integer page, Integer size);

    List<Order> statisticByDate(StatisticByDate statisticByDate);

    List<Order> statisticByProduct(StatisticByProduct statisticByProduct);

    List<ChartStatistical> setPerformanceWithChartList();

    List<ChartStatistical> totalsOfUses();

}
