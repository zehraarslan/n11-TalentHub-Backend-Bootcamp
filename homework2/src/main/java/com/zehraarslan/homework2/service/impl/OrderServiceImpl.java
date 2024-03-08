package com.zehraarslan.homework2.service.impl;

import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.entity.Company;
import com.zehraarslan.homework2.entity.Customer;
import com.zehraarslan.homework2.entity.Order;
import com.zehraarslan.homework2.mapper.OrderMapper;
import com.zehraarslan.homework2.repository.CompanyRepository;
import com.zehraarslan.homework2.repository.CustomerRepository;
import com.zehraarslan.homework2.repository.OrderRepository;
import com.zehraarslan.homework2.request.OrderSaveRequest;
import com.zehraarslan.homework2.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, CompanyRepository companyRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public OrderDto save(OrderSaveRequest request) {
        Order order = OrderMapper.INSTANCE.convertToOrder(request);
        order = orderRepository.save(order);
        OrderDto orderDto = OrderMapper.INSTANCE.convertToOrderDto(order);
        return orderDto;
    }

    @Override
    public List<OrderDto> saveAll(List<OrderSaveRequest> requests) {
        List<Order> orders = OrderMapper.INSTANCE.convertToOrders(requests);
        orders = orderRepository.saveAll(orders);
        List<OrderDto> orderDtos = OrderMapper.INSTANCE.convertToOrderDtos(orders);
        return orderDtos;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = OrderMapper.INSTANCE.convertToOrderDtos(orders);
        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrdersWithAmountGreaterThan(double amount) {
        List<Order> orders = orderRepository.findByAmountGreaterThan(amount);
        List<OrderDto> orderDtos = OrderMapper.INSTANCE.convertToOrderDtos(orders);
        return orderDtos;
    }

    @Override
    public double getAverageAmountOfOrdersAbove(double amount) {
        List<Order> orders = orderRepository.findByAmountGreaterThan(amount);
        double total = orders.stream().mapToDouble(Order::getAmount).sum();
        return orders.size() > 0 ? total / orders.size() : 0 ;
    }

    @Override
    public List<String> getCustomersWithOrdersBelow(double amount) {
        List<Order> orders = orderRepository.findByAmountLessThan(amount);
        return orders.stream()
                .map(order -> {
                    Customer customer = customerRepository.findById(order.getCustomerId()).orElse(null);
                    return customer != null ? customer.getName() : null;
                }).distinct().toList();
    }

    @Override
    public List<String> findByInvoiceDateMonthAndAmountGreaterThanEqual(int month, double amount) {
        List<Order> orders = orderRepository.findByInvoiceDateMonthAndAmountGreaterThanEqual(month, amount);
        return orders.stream()
                .map(order -> companyRepository.findById(order.getCompanyId()).orElse(null))
                .filter(company -> company != null)
                .map(Company::getSector)
                .distinct()
                .toList();
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) orderRepository.delete(order);
    }

}
