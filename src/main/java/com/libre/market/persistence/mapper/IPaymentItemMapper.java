package com.libre.market.persistence.mapper;

import com.libre.market.domain.PaymentItem;
import com.libre.market.persistence.entity.PaymentsProductsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IProductMapper.class})
public interface IPaymentItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    PaymentItem toPaymentItem(PaymentsProductsEntity product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "payment", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.paymentId", ignore = true)
    })
    PaymentsProductsEntity toPaymentsProducts(PaymentItem item);
}
