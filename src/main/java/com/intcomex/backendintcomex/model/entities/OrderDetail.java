package com.intcomex.backendintcomex.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderid")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productid")
    private Product product;
    @Column(name = "unitprice")
    private Double unitPrice;
    private Short quantity;
    private Float discount;
}
