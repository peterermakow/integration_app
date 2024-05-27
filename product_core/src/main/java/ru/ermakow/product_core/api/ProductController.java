package ru.ermakow.product_core.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.ermakow.dto.request.ProductTypeBalanceRequest;
import ru.ermakow.product_core.dto.ProductDto;
import ru.ermakow.product_core.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    public List<ProductDto> getAllProductsByUserId(String id) {
        return productService.getAllProductsByUserId(Long.valueOf(id));
    }

    public ResponseEntity<ProductDto> getProductByUserIdAndProductType(ProductTypeBalanceRequest productTypeBalanceRequest) {
        return productService.getProductByUserIdAndProductType(Long.valueOf(productTypeBalanceRequest.userId()), productTypeBalanceRequest.productType(), productTypeBalanceRequest.payment());
    }

}