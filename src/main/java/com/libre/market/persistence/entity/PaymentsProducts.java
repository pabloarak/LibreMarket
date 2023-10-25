package com.libre.market.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = 'payments_products')
public class PaymentsProducts {
    @EmbeddedId
    private PaymentsProductsPK id;
    private Integer quantity;
    private Double total;

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

    private Boolean state;
}
