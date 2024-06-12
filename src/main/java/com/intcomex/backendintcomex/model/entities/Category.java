package com.intcomex.backendintcomex.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Integer categoryId;

    @Column(name = "categoryname", nullable = false, length = 15)
    private String categoryName;

    private String description;

    @Column(name = "picture", columnDefinition = "bytea")
    private byte[] picture;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
