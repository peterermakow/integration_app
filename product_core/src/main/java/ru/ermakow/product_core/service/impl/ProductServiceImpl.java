package ru.ermakow.product_core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ermakow.product_core.dto.ProductDto;
import ru.ermakow.product_core.entity.ProductEntity;
import ru.ermakow.product_core.exception.UnprocessableEntityException;
import ru.ermakow.product_core.mapper.ProductMapper;
import ru.ermakow.product_core.repository.ProductRepository;
import ru.ermakow.product_core.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProductsByUserId(Long userId) {
        var products = productRepository.getAllProductsByUserId(userId);
        return productMapper.toProductDtoList(products);
    }
    
    @Override
    public ResponseEntity<ProductDto> getProductByUserIdAndProductType(Long id, String productType, BigDecimal payment) {
        ProductEntity product = productRepository.executePaymentByUserIdAndProductType(id, productType, payment)
                .orElseThrow(() -> new UnprocessableEntityException(String.format("Продукта указанного типа %s у клиента %d не найдено", productType, id)));
        return ResponseEntity.ok().body(productMapper.entityToProductDto(product));
    }

}
