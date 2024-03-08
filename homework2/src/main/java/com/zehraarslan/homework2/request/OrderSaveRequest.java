package com.zehraarslan.homework2.request;

import java.time.LocalDate;

public record OrderSaveRequest(Long customerId,
                               Long companyId,
                               Double amount,
                               LocalDate invoiceDate) {
}
