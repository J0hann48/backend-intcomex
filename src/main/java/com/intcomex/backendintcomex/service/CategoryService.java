package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.controllers.category.CategoryResponse;
import com.intcomex.backendintcomex.controllers.category.RegisterCategoryRequest;
import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.repository.CategoryRepository;
import com.intcomex.backendintcomex.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse register(RegisterCategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        category.setPicture(categoryRequest.getPicture());
        var categorySave = categoryRepository.save(category);

        return CategoryResponse.builder()
                .categoryId(categorySave.getCategoryId())
                .message("Category created OK")
                .build();
    }
}
