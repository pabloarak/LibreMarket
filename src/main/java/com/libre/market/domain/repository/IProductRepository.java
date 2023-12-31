package com.libre.market.domain.repository;

import com.libre.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
//    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int id);
    Product save(Product product);
    void delete(int productId);
}
