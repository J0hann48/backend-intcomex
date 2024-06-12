package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.controllers.category.CategoryResponse;
import com.intcomex.backendintcomex.controllers.category.RegisterCategoryRequest;
import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.repository.CategoryRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    private static final RegisterCategoryRequest CATEGORY_REQUEST = RegisterCategoryRequest.builder()
            .categoryName("Test Category")
            .description("Test Description")
            .picture("Test Picture".getBytes())
            .build();;

    private static final Category CATEGORY = Category.builder()
            .categoryName("Test Category")
            .description("Test Description")
            .picture("Test Picture".getBytes())
            .build();
    private static final Category SAVED_CATEGORY = Category.builder()
            .categoryId(1)
            .categoryName("Test Category")
            .description("Test Description")
            .picture("Test Picture".getBytes())
            .build();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
        when(categoryRepository.save(any(Category.class))).thenReturn(SAVED_CATEGORY);

        CategoryResponse response = categoryService.register(CATEGORY_REQUEST);

        ArgumentCaptor<Category> categoryCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryCaptor.capture());

        Category capturedCategory = categoryCaptor.getValue();
        assert capturedCategory.getCategoryName().equals("Test Category");
        assert capturedCategory.getDescription().equals("Test Description");
        assert new String(capturedCategory.getPicture()).equals("Test Picture");

        assert response.getCategoryId().equals(1);
        assert response.getMessage().equals("Category created OK");
    }

}