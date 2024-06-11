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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @Column(nullable = false, length = 40)
    private String companyName;
    @Column(nullable = false, length = 30)
    private String contactName;
    @Column(nullable = false, length = 30)
    private String contactTitle;
    @Column(nullable = false, length = 60)
    private String address;
    @Column(nullable = false, length = 15)
    private String city;
    @Column(nullable = false, length = 15)
    private String region;
    @Column(nullable = false, length = 10)
    private String postalCode;
    @Column(nullable = false, length = 15)
    private String country;
    @Column(nullable = false, length = 24)
    private String phone;
    @Column(nullable = false, length = 24)
    private String fax;
    private String homePage;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;
}
