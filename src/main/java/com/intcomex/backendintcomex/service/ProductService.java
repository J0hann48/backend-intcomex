package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.controllers.product.CreateProductRequest;
import com.intcomex.backendintcomex.controllers.product.ProductResponse;
import com.intcomex.backendintcomex.model.entities.Product;
import com.intcomex.backendintcomex.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponse create(CreateProductRequest request) {
        Product product = Product.builder()
                .productName(request.getProductName())
                .supplier(request.getSupplier())
                .category(request.getCategory())
                .quantityPerUnit(request.getQuantityPerUnit())
                .unitPrice(request.getUnitPrice())
                .unitsInStock(request.getUnitsInStock())
                .unitsOnOrder(request.getUnitsOnOrder())
                .reorderLevel(request.getReorderLevel())
                .discontinued(request.getDiscontinued())
                .build();
        var productSave = repository.save(product);
        return ProductResponse.builder()
                .productId(productSave.getProductId())
                .message("Product created OK")
                .build();
    }
}
