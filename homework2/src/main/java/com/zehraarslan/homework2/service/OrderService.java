package com.zehraarslan.homework2.service;

import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.entity.Order;
import com.zehraarslan.homework2.request.CustomerSaveRequest;
import com.zehraarslan.homework2.request.OrderSaveRequest;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderSaveRequest request);
    List<OrderDto> saveAll(List<OrderSaveRequest> requests);
    List<OrderDto> getAll();
    List<OrderDto> getOrdersWithAmountGreaterThan(double amount);
    double getAverageAmountOfOrdersAbove(double amount);
    List<String> getCustomersWithOrdersBelow(double amount);
    List<String> findByInvoiceDateMonthAndAmountGreaterThanEqual(int month, double amount);
    void delete(Long id);
}
