package com.zehraarslan.homework2.controllers;

import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.request.OrderSaveRequest;
import com.zehraarslan.homework2.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAllOrder() {
        return orderService.getAll();
    }

    @PostMapping
    public  OrderDto save(@RequestBody OrderSaveRequest request) {
        return orderService.save(request);
    }

    @GetMapping("/amount-greater-than-1500")
    public List<OrderDto>  getOrdersWithAmountGreaterThan1500() {
        return orderService.getOrdersWithAmountGreaterThan(1500);
    }

    @GetMapping("/average-amount-above-1500")
    public Double getAverageAmountOfOrdersAbove1500() {
        return orderService.getAverageAmountOfOrdersAbove(1500);
    }

    @GetMapping("/customers-with-orders-below-500")
    public List<String> getCustomersWithOrdersBelow500() {
        return orderService.getCustomersWithOrdersBelow(500);
    }

    @GetMapping("/company-sectors-average-below-750-in-june")
    public List<String> getCustomerSectorsWithAverageAmountBelow750InJune() {
        return orderService.findByInvoiceDateMonthAndAmountGreaterThanEqual(6, 750);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }
}
