package com.zehraarslan.homework2.request;

import java.time.LocalDate;

public record CustomerSaveRequest(String name,
                                  String sector,
                                  String email,
                                  String phoneNumber,
                                  LocalDate registrationDate) {
}
