package com.libre.market.persistence.crud;

import com.libre.market.persistence.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPaymentCrudRepository extends CrudRepository<PaymentEntity, Integer> {
    Optional<List<PaymentEntity>> findByClientId(String clientId);
}
