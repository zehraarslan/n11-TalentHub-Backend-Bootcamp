package com.zehraarslan.homework2.repository;

import com.zehraarslan.homework2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContainingIgnoreCase(String keyword);

    @Query("SELECT c FROM Customer c WHERE MONTH(c.registrationDate) = :month")
    List<Customer> findByRegistrationDateMonth(int month);
    String findCustomerNameById(Long id);
}
