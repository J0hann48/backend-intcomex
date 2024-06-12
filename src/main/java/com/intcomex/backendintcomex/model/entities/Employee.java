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
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private Integer employeeId;

    @Column(nullable = false, length = 20, name = "lastname")
    private String lastName;

    @Column(nullable = false, length = 10, name = "firstname")
    private String firstName;

    private String title;
    @Column(name = "titleofcourtesy")
    private String titleOfCourtesy;
    private Date birthdate;
    private Date hiredate;
    private String address;
    private String city;
    private String region;
    @Column(name = "postalcode")
    private String postalCode;
    private String country;
    @Column(name = "homephone")
    private String homePhone;
    private String extension;

    @Lob
    private byte[] photo;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "reportsto")
    private Employee reportsTo;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders;
}
