package ru.ermakow.payment_core.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ermakow.payment_core.dto.ProductResponseDto;
import ru.ermakow.payment_core.service.ProductsIntegrationService;

import java.math.BigDecimal;
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

    @GetMapping("/{type}/{id}/{payment}")
    public ProductResponseDto executePayment(@PathVariable String type,
                                             @PathVariable Long id,
                                             @PathVariable BigDecimal payment) {
        return productsIntegrationService.executePayment(type, id, payment);
    }

}
