package ru.ermakow.payment_core.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ermakow.dto.request.PaymentRequest;
import ru.ermakow.dto.response.ProductResponseDto;
import ru.ermakow.payment_core.service.ProductsIntegrationService;

import java.util.List;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentController {

    private final ProductsIntegrationService productsIntegrationService;

    @GetMapping("/{id}")
    public List<ProductResponseDto> getAllProductsByClientId(@PathVariable Long id) {
        return productsIntegrationService.getAllProductsByClientId(id);
    }

    @PostMapping
    public ProductResponseDto executePayment(@RequestBody PaymentRequest paymentRequest) {
        return productsIntegrationService.executePayment(paymentRequest);
    }

}
