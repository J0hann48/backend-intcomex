package com.intcomex.backendintcomex.model.repository;

import com.intcomex.backendintcomex.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
