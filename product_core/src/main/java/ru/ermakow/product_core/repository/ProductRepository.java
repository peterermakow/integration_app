package ru.ermakow.product_core.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.ermakow.product_core.config.DataSource;
import ru.ermakow.product_core.entity.ProductEntity;
import ru.ermakow.product_core.exception.InsufficientAccountBalanceException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final String GET_ALL_PRODUCTS_BY_USERID_QUERY =
            "SELECT product_id, user_id, account_number, account_balance, product_type FROM products WHERE user_id = ?";
    private final String EXECUTE_PAYMENT =
            "UPDATE products SET account_balance = account_balance - ? WHERE user_id = ? AND product_type = ? RETURNING *;";

    private final DataSource dataSource;

    public List<ProductEntity> getAllProductsByUserId(Long userId) {
        List<ProductEntity> products;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(GET_ALL_PRODUCTS_BY_USERID_QUERY);
            pst.setLong(1, userId);
            ResultSet rs = pst.executeQuery();
            products = new ArrayList<>();
            ProductEntity product;
            while (rs.next()) {
                product = new ProductEntity(
                        rs.getLong("product_id"),
                        rs.getLong("user_id"),
                        rs.getLong("account_number"),
                        rs.getBigDecimal("account_balance"),
                        rs.getString("product_type"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Optional<ProductEntity> executePaymentByUserIdAndProductType(Long id, String productType, BigDecimal payment)  {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(EXECUTE_PAYMENT);
            pst.setBigDecimal(1, payment);
            pst.setLong(2, id);
            pst.setString(3, productType);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return Optional.of(new ProductEntity(
                        rs.getLong("product_id"),
                        rs.getLong("user_id"),
                        rs.getLong("account_number"),
                        rs.getBigDecimal("account_balance"),
                        rs.getString("product_type")));
            }
        } catch (SQLException e) {
            throw new InsufficientAccountBalanceException("Недостаточный баланс для осуществления платежа");
        }
        return Optional.empty();
    }
}
