package com.intcomex.backendintcomex.controllers.product;

import com.intcomex.backendintcomex.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final PagedResourcesAssembler<ProductResponse> pagedResourcesAssembler;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ProductResponse>>> listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ProductResponse> productPage = productService.getAllProducts(page, size);
        PagedModel<EntityModel<ProductResponse>> pagedModel = pagedResourcesAssembler.toModel(productPage);
        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponse> register() throws IOException {
        return ResponseEntity.ok(productService.generateRandomProducts());
    }

}
