package com.intcomex.backendintcomex.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private java.sql.Date orderDate;
    private java.sql.Date requiredDate;
    private java.sql.Date shippedDate;

    @ManyToOne
    @JoinColumn(name = "shipVia")
    private Shipper shipper;

    private Double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
