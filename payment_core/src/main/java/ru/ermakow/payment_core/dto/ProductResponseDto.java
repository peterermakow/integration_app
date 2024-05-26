package ru.ermakow.payment_core.dto;

public record ProductResponseDto(String userId,
                                 String accountNumber,
                                 String accountBalance,
                                 String productType) {}