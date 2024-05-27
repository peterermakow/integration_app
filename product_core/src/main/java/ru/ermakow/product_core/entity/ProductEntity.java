package ru.ermakow.product_core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductEntity {

    private Long productId;
    private Long userId;
    private Long accountNumber;
    private BigDecimal accountBalance;
    private String productType; // подразумевается, что у клиента могут бытьт продукты двух типов DEBET/CREDIT
}
