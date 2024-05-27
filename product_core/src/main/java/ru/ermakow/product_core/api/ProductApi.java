package ru.ermakow.product_core.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.ermakow.dto.request.ProductTypeBalanceRequest;
import ru.ermakow.product_core.dto.ProductDto;
import ru.ermakow.product_core.util.UriConstants;

import java.util.List;

public interface ProductApi {

    @GetMapping(UriConstants.USER_PATH)
    List<ProductDto> getAllProductsByUserId(@RequestHeader String id);

    @PostMapping(UriConstants.PRODUCT_PATH)
    ResponseEntity<ProductDto> getProductByUserIdAndProductType(@RequestBody ProductTypeBalanceRequest productTypeBalanceRequest);
}
