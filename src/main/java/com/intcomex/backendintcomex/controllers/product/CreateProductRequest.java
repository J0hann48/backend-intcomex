package com.intcomex.backendintcomex.controllers.product;

import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotBlank(message = "product name is mandatory")
    private String productName;
    @NotBlank(message = "Supplier is mandatory")
    private Supplier supplier;
    @NotBlank(message = "Category is mandatory")
    private Category category;
    private String quantityPerUnit;
    private Double unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private Boolean discontinued;
}
