package com.libre.market.domain.repository;

import com.libre.market.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
    List<Payment> getAll();
    Optional<List<Payment>> getByClient(String clientId);
    Payment save(Payment purchase);
}
