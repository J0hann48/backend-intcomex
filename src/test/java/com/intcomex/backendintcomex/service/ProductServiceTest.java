package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.controllers.product.ProductResponse;
import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.entities.Product;
import com.intcomex.backendintcomex.model.entities.Supplier;
import com.intcomex.backendintcomex.model.repository.CategoryRepository;
import com.intcomex.backendintcomex.model.repository.ProductRepository;
import com.intcomex.backendintcomex.model.repository.SupplierRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
public class ProductServiceTest {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    private SupplierRepository supplierRepository;

    private ProductService productService;

    /**private Category cloudCategory;
    private Category serversCategory;
    private Supplier supplier;
    private Product savedProduct;
    **/

    private static final Category CLOUD_CATEGORY = Category.builder()
            .categoryId(1)
                .categoryName("CLOUD")
                .build();

    private static final Category SERVER_CATEGORY = Category.builder()
            .categoryId(2)
                .categoryName("SERVIDORES")
                .build();

    private static final Supplier SUPPLIER = Supplier.builder()
            .supplierId(1)
                .companyName("Supplier 1")
                .build();

    private static final Product PRODUCT = Product.builder()
            .productId(1)
                .productName("Test Product")
                .supplier(SUPPLIER)
                .category(CLOUD_CATEGORY)
                .quantityPerUnit("10 unidades por caja")
                .unitPrice(100.0)
                .unitsInStock((short) 10)
            .unitsOnOrder((short) 5)
            .reorderLevel((short) 2)
            .discontinued(false)
                .build();

    @BeforeEach
    public void setUp() {

        openMocks(this);
    }

    @Test
    public void testGenerateRandomProducts() {

        categoryRepository = mock(CategoryRepository.class);
        supplierRepository = mock(SupplierRepository.class);
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository, categoryRepository, supplierRepository);

        when(categoryRepository.findByCategoryName("CLOUD")).thenReturn(CLOUD_CATEGORY);
        when(categoryRepository.findByCategoryName("SERVIDORES")).thenReturn(SERVER_CATEGORY);
        when(supplierRepository.findAll()).thenReturn(Arrays.asList(SUPPLIER));
        when(productRepository.save(any(Product.class))).thenReturn(PRODUCT);

        ProductResponse response = productService.generateRandomProducts();


        assert response.getMessage().equals("Random products generated successfully");
    }
}
