package ru.ermakow.product_core.mapper;

import org.springframework.stereotype.Component;
import ru.ermakow.dto.response.ProductResponseDto;
import ru.ermakow.product_core.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

@Component
public class ProductMapper {

    public ProductResponseDto entityToProductDto(ProductEntity entity) {
        return ProductResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .accountNumber(String.valueOf(entity.getAccountNumber()))
                .accountBalance(String.valueOf(entity.getAccountBalance()))
                .productType(entity.getProductType().toString())
                .build();
    }

    public List<ProductResponseDto> toProductDtoList(Collection<ProductEntity> collection) {
        return collection.stream()
                .map(this::entityToProductDto)
                .toList();
    }
}
