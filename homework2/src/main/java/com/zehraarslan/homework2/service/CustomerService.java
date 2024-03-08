package com.zehraarslan.homework2.service;

import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.entity.Customer;
import com.zehraarslan.homework2.request.CustomerSaveRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerSaveRequest request);
    List<CustomerDto> saveAll(List<CustomerSaveRequest> requests);
    List<CustomerDto> getAll();
    List<CustomerDto> getCustomersWithNameContainingC();
    double getCustomersRegisteredInMonth(int month);
    void delete(Long id);

    String getCustomerNameById(Long customerId);
}
