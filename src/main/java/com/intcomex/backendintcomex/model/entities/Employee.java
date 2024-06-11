package com.intcomex.backendintcomex.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 10)
    private String firstName;

    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;

    @Lob
    private byte[] photo;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders;
}
