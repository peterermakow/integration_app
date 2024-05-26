package ru.ermakow.product_core.mapper;

import org.springframework.stereotype.Component;
import ru.ermakow.product_core.dto.ProductDto;
import ru.ermakow.product_core.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

@Component
public class ProductMapper {

    public ProductDto entityToProductDto(ProductEntity entity) {
        return ProductDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .accountNumber(String.valueOf(entity.getAccountNumber()))
                .accountBalance(String.valueOf(entity.getAccountBalance()))
                .productType(entity.getProductType())
                .build();
    }

    public List<ProductDto> toProductDtoList(Collection<ProductEntity> collection) {
        return collection.stream()
                .map(this::entityToProductDto)
                .toList();
    }
}
