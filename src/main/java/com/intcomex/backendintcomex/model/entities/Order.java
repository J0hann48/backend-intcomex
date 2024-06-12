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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;

    private java.sql.Date orderdate;
    private java.sql.Date requireddate;
    private java.sql.Date shippeddate;

    @ManyToOne
    @JoinColumn(name = "shipvia")
    private Shipper shipper;

    private Double freight;
    @Column(name = "shipname")
    private String shipName;
    @Column(name = "shipaddress")
    private String shipAddress;
    @Column(name = "shipcity")
    private String shipCity;
    @Column(name = "shipregion")
    private String shipRegion;
    @Column(name = "shippostalcode")
    private String shipPostalCode;
    @Column(name = "shipcountry")
    private String shipCountry;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
