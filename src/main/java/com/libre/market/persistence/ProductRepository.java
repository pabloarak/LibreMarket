package com.libre.market.persistence;

import com.libre.market.persistence.crud.ProductCrudRepository;
import com.libre.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
