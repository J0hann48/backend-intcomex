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
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipperid")
    private Integer shipperId;

    @Column(nullable = false, length = 40, name = "companyname")
    private String companyName;

    private String phone;

    @OneToMany(mappedBy = "shipper")
    private Set<Order> orders;
}
