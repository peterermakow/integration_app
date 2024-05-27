package ru.ermakow.product_core.service;

import org.springframework.http.ResponseEntity;
import ru.ermakow.dto.request.PaymentRequest;
import ru.ermakow.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProductsByUserId(Long userId);

    ResponseEntity<ProductResponseDto> processPayment(PaymentRequest request);
}
