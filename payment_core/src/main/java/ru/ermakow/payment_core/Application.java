package ru.ermakow.payment_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.ermakow.payment_core.config.properties.ExecutorsProperties;

@SpringBootApplication
@EnableConfigurationProperties({ExecutorsProperties.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
