package com.intcomex.backendintcomex.model.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private Integer orderId;
    private Integer productId;
}
