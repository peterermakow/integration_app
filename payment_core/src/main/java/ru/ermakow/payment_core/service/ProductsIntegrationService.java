package ru.ermakow.payment_core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ermakow.dto.request.ProductTypeBalanceRequest;
import ru.ermakow.payment_core.dto.ProductResponseDto;
import ru.ermakow.payment_core.config.properties.ExecutorsProperties;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsIntegrationService {

    private final RestTemplate restTemplate;

    private final ExecutorsProperties executorsProperties;


    public List<ProductResponseDto> getAllProductsByClientId(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("id", String.valueOf(id));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List<ProductResponseDto>> response =
                restTemplate.exchange("/user", HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductResponseDto>>() {});
        return response.getBody();
    }

    /**
     * в случсае успешнрого платежа метод вернет ProductResponseDto с обновленным балансом клиента, в противном случае 422/423 с описанием ошибки(нет продукта или же недостаточно купилок)
     */
    public ProductResponseDto executePayment(String type, Long id, BigDecimal payment) {
        return restTemplate.postForObject(
                "/product",
                new ProductTypeBalanceRequest(String.valueOf(id), type, payment),
                ProductResponseDto.class
        );
    }
}
