package ru.ermakow.product_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ermakow.enums.ProductType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;
}
