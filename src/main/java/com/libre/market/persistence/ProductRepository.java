package com.libre.market.persistence;

import com.libre.market.persistence.crud.ProductCrudRepository;
import com.libre.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int categoryId) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }

    public Optional<List<Product>> getScarces(int quantity) {
        return productCrudRepository.findByQuantityStockLessThanAndState(quantity);
    }
}
