package ru.ermakow.dto.request;

import java.math.BigDecimal;

public record ProductTypeBalanceRequest(String userId, String productType, BigDecimal payment) {
}
