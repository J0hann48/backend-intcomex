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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productId;

    @Column(nullable = false, length = 40, name = "productname")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "quantityperunit")
    private String quantityPerUnit;
    @Column(name = "unitprice")
    private Double unitPrice;
    @Column(name = "unitsinstock")
    private Short unitsInStock;
    @Column(name = "unitsonorder")
    private Short unitsOnOrder;
    @Column(name = "reorderlevel")
    private Short reorderLevel;
    private Boolean discontinued;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;
}
