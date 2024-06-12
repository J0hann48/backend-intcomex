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
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerid")
    private String customerId;

    @Column(nullable = false, length = 40, name = "companyname")
    private String companyName;
    @Column(name = "contactname")
    private String contactName;
    @Column(name = "contacttitle")
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    @Column(name = "postalcode")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
