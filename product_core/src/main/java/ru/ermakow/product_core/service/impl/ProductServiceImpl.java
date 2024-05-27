package ru.ermakow.product_core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ermakow.dto.request.PaymentRequest;
import ru.ermakow.dto.response.ProductResponseDto;
import ru.ermakow.enums.ProductType;
import ru.ermakow.product_core.entity.ProductEntity;
import ru.ermakow.product_core.exception.InsufficientBalanceException;
import ru.ermakow.product_core.exception.UnprocessableEntityException;
import ru.ermakow.product_core.mapper.ProductMapper;
import ru.ermakow.product_core.repository.ProductRepository;
import ru.ermakow.product_core.service.ProductService;

import java.util.List;

import static ru.ermakow.product_core.util.Constants.VALUE;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> getAllProductsByUserId(Long userId) {
        List<ProductEntity> products = productRepository.getProductEntitiesByUserId(userId);
        return productMapper.toProductDtoList(products);
    }

    @Transactional
    @Override
    public ResponseEntity<ProductResponseDto> processPayment(PaymentRequest request) {

        ProductEntity product = productRepository.getProductEntityByUserIdAndProductType(Long.valueOf(request.userId()), ProductType.valueOf(request.productType()))
                .orElseThrow(() -> new UnprocessableEntityException(String.format("Продукта указанного типа %s у клиента %s не найдено", request.productType(), request.userId())));


        var payment = request.payment();
        if (product.getAccountBalance().compareTo(payment) == VALUE) {
            throw new InsufficientBalanceException("Недостаточно средств для совершщения платежа");
        }
        product.setAccountBalance(product.getAccountBalance().subtract(payment));
        return ResponseEntity.ok().body(productMapper.entityToProductDto(productRepository.save(product)));
    }

}

