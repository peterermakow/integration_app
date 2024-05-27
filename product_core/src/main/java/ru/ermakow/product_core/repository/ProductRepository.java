package ru.ermakow.product_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ermakow.enums.ProductType;
import ru.ermakow.product_core.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> getProductEntitiesByUserId(Long userId);

    Optional<ProductEntity> getProductEntityByUserIdAndProductType(Long userId, ProductType productType);
}
