package com.libre.market.persistence;

import com.libre.market.domain.Payment;
import com.libre.market.domain.Product;
import com.libre.market.domain.repository.IPaymentRepository;
import com.libre.market.persistence.crud.IPaymentCrudRepository;
import com.libre.market.persistence.crud.IProductCrudRepository;
import com.libre.market.persistence.entity.PaymentEntity;
import com.libre.market.persistence.entity.ProductEntity;
import com.libre.market.persistence.mapper.IPaymentMapper;
import com.libre.market.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentRepository implements IPaymentRepository {
    @Autowired
    private IPaymentCrudRepository paymentCrudRepository;

    @Autowired
    private IPaymentMapper mapper;

    @Override
    public List<Payment> getAll() {
        return mapper.toPayments((List<PaymentEntity>) paymentCrudRepository.findAll());
    }

    @Override
    public Optional<List<Payment>> getByClient(String clientId) {
        return paymentCrudRepository.findByClientId(clientId)
                .map(payments -> mapper.toPayments(payments));
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = mapper.toPayment(payment);
        paymentEntity.getProducts().forEach(product -> product.setPayment(paymentEntity));

        return mapper.toPayment(paymentCrudRepository.save(paymentEntity));
    }
}
