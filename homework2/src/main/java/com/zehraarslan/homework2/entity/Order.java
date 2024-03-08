package com.zehraarslan.homework2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order")
    @SequenceGenerator(name = "Order", sequenceName = "ORDER_ID_SEQ")
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;
    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;
    @Column(name = "INVOICE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate invoiceDate;
}
