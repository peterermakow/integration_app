package ru.ermakow.product_core.service;

import org.springframework.http.ResponseEntity;
import ru.ermakow.product_core.dto.ProductDto;
import ru.ermakow.product_core.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProductsByUserId(Long userId);

    ResponseEntity<ProductDto> getProductByUserIdAndProductType(Long id, String productType, BigDecimal payment);
}
