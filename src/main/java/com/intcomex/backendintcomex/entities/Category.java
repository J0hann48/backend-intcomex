package com.intcomex.backendintcomex.entities;

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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(nullable = false, length = 15)
    private String categoryName;

    private String description;

    @Lob
    private byte[] picture;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
