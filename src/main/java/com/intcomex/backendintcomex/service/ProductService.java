package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.controllers.product.CreateProductRequest;
import com.intcomex.backendintcomex.controllers.product.ProductResponse;
import com.intcomex.backendintcomex.exception.ProductNotFoundException;
import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.entities.Product;
import com.intcomex.backendintcomex.model.entities.Supplier;
import com.intcomex.backendintcomex.model.repository.CategoryRepository;
import com.intcomex.backendintcomex.model.repository.ProductRepository;
import com.intcomex.backendintcomex.model.repository.SupplierRepository;
import com.intcomex.backendintcomex.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductResponse generateRandomProducts() {
        Category cloudCategory = categoryRepository.findByCategoryName("CLOUD");
        Category serversCategory = categoryRepository.findByCategoryName("SERVIDORES");

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            Category category = random.nextBoolean() ? cloudCategory : serversCategory;

            Product product = Product.builder()
                    .productName(generateRandomName())
                    .supplier(generateRandomSupplier())
                    .category(category)
                    .quantityPerUnit(generateRandomQuantity())
                    .unitPrice(generateRandomPrice())
                    .unitsInStock((short) random.nextInt(1000))
                    .unitsOnOrder((short) random.nextInt(100))
                    .reorderLevel((short) random.nextInt(50))
                    .discontinued(random.nextBoolean())
                    .build();

            repository.save(product);
        }
        return ProductResponse.builder()
                .message("Random products generated successfully")
                .build();
    }

    private Double generateRandomPrice() {
        return Math.round(Math.random() * 1000 * 100.0) / 100.0;
    }

    private String generateRandomQuantity() {
        int units = new Random().nextInt(50) + 1;
        return units + " unidades por caja";
    }

    private Supplier generateRandomSupplier() {
        List<Supplier> suppliers = supplierRepository.findAll();
        int randomIndex = new Random().nextInt(suppliers.size());
        return suppliers.get(randomIndex);
    }

    private String generateRandomName() {
        String[] adjectives = {"Pequeño", "Grande", "Excelente", "Fantástico", "Nuevo", "Único"};
        String[] nouns = {"Computadora", "Servidor", "Almacenamiento", "Software", "Hardware", "Dispositivo"};

        String adjective = adjectives[new Random().nextInt(adjectives.length)];
        String noun = nouns[new Random().nextInt(nouns.length)];

        return adjective + " " + noun;
    }

    public Page<ProductResponse> getAllProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productPage = repository.findAll(pageRequest);

        return productPage.map(this::convertToProductResponse);
    }

    public ProductResponse getProductById(Integer id) {
        Optional<Product> productOptional = repository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return convertToProductResponse(product);
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    private ProductResponse convertToProductResponse(Product product) {
        byte[] decompressedPicture = ImageUtil.decompressImage(product.getCategory().getPicture());

        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .supplierId(product.getSupplier().getSupplierId())
                .categoryId(product.getCategory().getCategoryId())
                .quantityPerUnit(product.getQuantityPerUnit())
                .unitPrice(product.getUnitPrice())
                .unitsInStock(product.getUnitsInStock())
                .unitsOnOrder(product.getUnitsOnOrder())
                .reorderLevel(product.getReorderLevel())
                .discontinued(product.getDiscontinued())
                .categoryPicture(decompressedPicture)
                .build();
    }


}
