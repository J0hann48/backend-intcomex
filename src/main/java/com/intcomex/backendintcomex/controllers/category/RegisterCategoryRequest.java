package com.intcomex.backendintcomex.controllers.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCategoryRequest {
    @NotBlank(message = "Category name is mandatory")
    private String categoryName;
    private String description;
    private byte[] picture;
}
