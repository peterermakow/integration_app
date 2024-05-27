package ru.ermakow.product_core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DataSource {

    private final ApplicationProperties properties;
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public DataSource(ApplicationProperties properties) {
        this.properties = properties;

        config.setJdbcUrl(properties.getJdbcUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());
        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
