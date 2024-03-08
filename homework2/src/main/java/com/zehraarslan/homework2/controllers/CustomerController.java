package com.zehraarslan.homework2.controllers;

import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.request.CustomerSaveRequest;
import com.zehraarslan.homework2.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto saveCustomer(@RequestBody CustomerSaveRequest request) {
        return customerService.save(request);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/contains-C")
    public List<CustomerDto> getCustomersWithNameContainingC() {
        return customerService.getCustomersWithNameContainingC();
    }

    @GetMapping("/registered-in-june")
    public double getCustomersRegisteredInJune() {
        return customerService.getCustomersRegisteredInMonth(6);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }
}
