package com.libre.market.persistence;

import com.libre.market.domain.Product;
import com.libre.market.domain.repository.IProductRepository;
import com.libre.market.persistence.crud.IProductCrudRepository;
import com.libre.market.persistence.entity.ProductEntity;
import com.libre.market.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private IProductCrudRepository productCrudRepository;
    @Autowired
    private IProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

/*    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> products = productCrudRepository.findByQuantityStockLessThanAndState(quantity);
        return products.map(prods -> mapper.toProducts(prods));
    }*/

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
