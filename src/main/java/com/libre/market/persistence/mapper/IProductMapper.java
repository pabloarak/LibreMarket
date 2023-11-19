package com.libre.market.persistence.mapper;

import com.libre.market.domain.Product;
import com.libre.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICategoryMapper.class})
public interface IProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    Product toProduct(ProductEntity product);
    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "code", ignore = true)
    ProductEntity toProduct(Product product);
}
