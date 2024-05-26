package ru.ermakow.product_core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String userId;
    private String accountNumber;
    private String accountBalance;
    private String productType;
}
