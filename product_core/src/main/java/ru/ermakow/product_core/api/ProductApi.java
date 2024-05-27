package ru.ermakow.product_core.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.ermakow.dto.request.PaymentRequest;
import ru.ermakow.dto.response.ProductResponseDto;
import ru.ermakow.product_core.util.UriConstants;

import java.util.List;

public interface ProductApi {

    @GetMapping(UriConstants.USER_PATH)
    List<ProductResponseDto> getAllProductsByUserId(@RequestHeader String id);

    @PostMapping(UriConstants.PAYMENT_PATH)
    ResponseEntity<ProductResponseDto> processPayment(@RequestBody PaymentRequest request);
}
