package com.libre.market.domain.service;

import com.libre.market.domain.Payment;
import com.libre.market.persistence.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAll() {
        return paymentRepository.getAll();
    }

    public Optional<List<Payment>> getByClient(String clientId) {
        return paymentRepository.getByClient(clientId);
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
