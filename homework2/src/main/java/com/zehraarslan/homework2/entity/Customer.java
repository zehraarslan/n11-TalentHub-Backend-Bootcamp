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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "SECTOR", length = 100, nullable = false)
    private String sector;
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;
    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;
    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDate registrationDate;


}
