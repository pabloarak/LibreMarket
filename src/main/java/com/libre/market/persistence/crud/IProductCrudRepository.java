package com.libre.market.persistence.crud;

import com.libre.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);
    Optional<List<ProductEntity>> findByQuantityStockLessThanAndState(int quantityStock);
}
