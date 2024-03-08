package com.zehraarslan.homework2.service.impl;

import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.entity.Customer;
import com.zehraarslan.homework2.entity.Order;
import com.zehraarslan.homework2.mapper.CustomerMapper;
import com.zehraarslan.homework2.repository.CustomerRepository;
import com.zehraarslan.homework2.repository.OrderRepository;
import com.zehraarslan.homework2.request.CustomerSaveRequest;
import com.zehraarslan.homework2.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public CustomerDto save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        if (customer.getRegistrationDate() == null) {
            customer.setRegistrationDate(LocalDate.now());
        }
        customerRepository.save(customer);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDto> saveAll(List<CustomerSaveRequest> requests) {
        List<Customer> customers = CustomerMapper.INSTANCE.convertToCustomers(requests);
        customers = customerRepository.saveAll(customers);
        List<CustomerDto> customerDtos = CustomerMapper.INSTANCE.convertToCustomerDtos(customers);
        return customerDtos;
    }

    @Override
    public List<CustomerDto> getAll() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.convertToCustomerDtos(customers);
        return customerDtoList;
    }

    @Override
    public List<CustomerDto> getCustomersWithNameContainingC() {

        List<Customer> customers = customerRepository.findByNameContainingIgnoreCase("C");
        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.convertToCustomerDtos(customers);
        return customerDtoList;
    }

    @Override
    public double getCustomersRegisteredInMonth(int month) {
        List<Customer> customers = customerRepository.findByRegistrationDateMonth(month);
        double totalAmount = 0.0;
        for (Customer customer : customers) {
            List<Order> orders = orderRepository.findByCustomerId(customer.getId());
            for (Order order : orders) {
                totalAmount += order.getAmount();
            }
        }
        return totalAmount;
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }

    @Override
    public String getCustomerNameById(Long customerId) {
        return customerRepository.findCustomerNameById(customerId);
    }

}
