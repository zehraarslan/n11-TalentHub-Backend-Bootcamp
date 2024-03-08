package com.zehraarslan.homework2.dto;

import java.time.LocalDate;

public record OrderDto(Long id,
                       Long customerId,
                       Long companyId,
                       Double amount,
                       LocalDate invoiceDate) {
}
