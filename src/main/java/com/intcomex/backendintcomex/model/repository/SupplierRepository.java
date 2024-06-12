package com.intcomex.backendintcomex.model.repository;

import com.intcomex.backendintcomex.model.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
