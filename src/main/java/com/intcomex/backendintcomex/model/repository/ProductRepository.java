package com.intcomex.backendintcomex.model.repository;

import com.intcomex.backendintcomex.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
