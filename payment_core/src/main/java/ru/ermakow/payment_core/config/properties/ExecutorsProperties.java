package ru.ermakow.payment_core.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "integrations.products.client")
public class ExecutorsProperties {

    private final RestTemplateProperties restTemplateProperties;

    public ExecutorsProperties(RestTemplateProperties restTemplateProperties) {
        this.restTemplateProperties = restTemplateProperties;
    }
}
