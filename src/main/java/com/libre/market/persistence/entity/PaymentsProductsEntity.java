package com.libre.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments_products")
public class PaymentsProductsEntity {
    @EmbeddedId
    private PaymentsProductsPKEntity id;
    private Integer quantity;
    private Double total;
    private Boolean state;

    @ManyToOne
    @MapsId("paymentId")
    @JoinColumn(name = "payment_id", insertable = false, updatable = false)
    private PaymentEntity payment;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    public PaymentsProductsPKEntity getId() {
        return id;
    }

    public void setId(PaymentsProductsPKEntity id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
