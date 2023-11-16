package com.libre.market.persistence.mapper;

import com.libre.market.domain.CategoryDomain;
import com.libre.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    CategoryDomain toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDomain category);
}
