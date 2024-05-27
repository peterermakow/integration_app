package ru.ermakow.product_core.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.ermakow.dto.request.PaymentRequest;
import ru.ermakow.dto.response.ProductResponseDto;
import ru.ermakow.product_core.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    public List<ProductResponseDto> getAllProductsByUserId(String id) {
        return productService.getAllProductsByUserId(Long.valueOf(id));
    }

    public ResponseEntity<ProductResponseDto> processPayment(PaymentRequest request) {
        return productService.processPayment(request);
    }

}