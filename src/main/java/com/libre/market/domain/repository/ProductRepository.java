package com.libre.market.domain.repository;

import com.libre.market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProduct(int id);
    ProductDomain save(ProductDomain product);
    void delete(int id);
}
