package com.libre.market.persistence.crud;

import com.libre.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);
    Optional<List<Product>> findByQuantityStockLessThanAndState(int quantityStock);
}
