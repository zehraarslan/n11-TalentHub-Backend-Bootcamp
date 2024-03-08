package com.zehraarslan.homework2.dto;

import java.time.LocalDate;

public record CustomerDto(Long id,
                          String name ,
                          String sector,
                          String email,
                          String phoneNumber,
                          LocalDate registrationDate) {
}
