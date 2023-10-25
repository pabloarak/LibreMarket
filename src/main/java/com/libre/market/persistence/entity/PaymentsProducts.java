package com.libre.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = 'payments_products')
public class PaymentsProducts {
    @EmbeddedId
    private PaymentsProductsPK id;
    private Integer quantity;
    private Double total;
    private Boolean state;
    @ManyToOne
    @JoinColumn(name = "payment_id", insertable = false, updatable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public PaymentsProductsPK getId() {
        return id;
    }

    public void setId(PaymentsProductsPK id) {
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
}
