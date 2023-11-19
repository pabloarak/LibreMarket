package com.libre.market.persistence.mapper;

import com.libre.market.domain.Payment;
import com.libre.market.persistence.entity.PaymentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPaymentItemMapper.class})
public interface IPaymentMapper {
    @Mappings({
            @Mapping(source = "id", target = "paymentId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    Payment toPayment(PaymentEntity payment);
    List<Payment> toPayments(List<PaymentEntity> payments);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PaymentEntity toPayment(Payment payment);
}
