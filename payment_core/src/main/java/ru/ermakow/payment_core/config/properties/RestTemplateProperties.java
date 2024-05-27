package ru.ermakow.payment_core.config.properties;

import lombok.Data;

import java.time.Duration;

@Data
public class RestTemplateProperties {

    private String url;
    private Duration connectTimeout;
    private Duration readTimeout;
}
