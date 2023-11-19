package com.libre.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_id")
    private String clientId;
    private LocalDateTime date;
    @Column(name = "payment_method")
    private String paymentMethod;
    private String comment;
    private String state;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientEntity client;

    @OneToMany(mappedBy = "payment")
    private List<PaymentsProductsEntity> payments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<PaymentsProductsEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentsProductsEntity> payments) {
        this.payments = payments;
    }
}
