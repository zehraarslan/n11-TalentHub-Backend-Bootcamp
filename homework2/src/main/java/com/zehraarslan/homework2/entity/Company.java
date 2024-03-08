package com.zehraarslan.homework2.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Company")
    @SequenceGenerator(name = "Company", sequenceName = "COMPANY_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "SECTOR", length = 100, nullable = false)
    private String sector;
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;
    @Column(name = "NUMBER", length = 100, nullable = false)
    private String number;
    @Column(name = "ADDRESS", length = 100, nullable = false)
    private String address;
}
