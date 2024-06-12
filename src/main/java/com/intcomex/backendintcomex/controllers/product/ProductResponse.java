package com.intcomex.backendintcomex.controllers.product;

import com.intcomex.backendintcomex.model.entities.Category;
import com.intcomex.backendintcomex.model.entities.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends RepresentationModel<ProductResponse> {
    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String quantityPerUnit;
    private Double unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private Boolean discontinued;
    private String message;
    private byte[] categoryPicture;
}
