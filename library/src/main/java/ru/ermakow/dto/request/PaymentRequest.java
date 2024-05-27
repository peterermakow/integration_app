package ru.ermakow.dto.request;

import java.math.BigDecimal;

public record PaymentRequest(String userId, String productType, BigDecimal payment) {
}
