package com.zehraarslan.homework2.repository;

import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByAmountGreaterThan(Double amount);
    List<Order> findByAmountLessThan(Double amount);

    @Query("SELECT o FROM Order o WHERE MONTH(o.invoiceDate) = :month AND o.amount >= :amount")
    List<Order> findByInvoiceDateMonthAndAmountGreaterThanEqual(int month, double amount);

    List<Order> findByCustomerId(Long customerId);
}
