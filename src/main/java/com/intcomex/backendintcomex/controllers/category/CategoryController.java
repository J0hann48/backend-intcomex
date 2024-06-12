package com.intcomex.backendintcomex.controllers.category;

import com.intcomex.backendintcomex.service.CategoryService;
import com.intcomex.backendintcomex.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public ResponseEntity<CategoryResponse> register( @RequestParam("categoryName") String categoryName,
                                                      @RequestParam("description") String description,
                                                      @Valid @RequestParam("picture") MultipartFile picture) throws IOException {
        RegisterCategoryRequest categoryRequest = new RegisterCategoryRequest();
        if (!picture.isEmpty()){
            categoryRequest = new RegisterCategoryRequest.RegisterCategoryRequestBuilder()
                    .categoryName(categoryName)
                    .description(description)
                    .picture(ImageUtil.compressImage(picture.getBytes()))
                    .build();
            logger.info("Request received for register a category: {}", categoryRequest.getCategoryName());
        }
        return ResponseEntity.ok(categoryService.register(categoryRequest));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage()
                ));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
