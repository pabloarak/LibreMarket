package com.libre.market.persistence;

import com.libre.market.persistence.crud.ProductCrudRepository;
import com.libre.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
