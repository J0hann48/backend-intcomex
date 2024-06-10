package com.intcomex.backendintcomex.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private Integer orderId;
    private Integer productId;
}
