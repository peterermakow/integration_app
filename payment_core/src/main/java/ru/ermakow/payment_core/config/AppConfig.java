package ru.ermakow.payment_core.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import ru.ermakow.payment_core.config.properties.ExecutorsProperties;
import ru.ermakow.payment_core.handler.RestTemplateErrorResponseHandler;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public RestTemplate productIntegrationExecutor(ExecutorsProperties executorsProperties, RestTemplateErrorResponseHandler responseHandler) {
        return new RestTemplateBuilder()
                .rootUri(executorsProperties.getRestTemplateProperties().getUrl())
                .setConnectTimeout(executorsProperties.getRestTemplateProperties().getConnectTimeout())
                .setReadTimeout(executorsProperties.getRestTemplateProperties().getReadTimeout())
                .errorHandler(responseHandler)
                .build();
    }
}
