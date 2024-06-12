package com.intcomex.backendintcomex.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Backend intcomex",
                version = "1.0.0",
                description = "Is a test for company"
        )
)
public class OpenApiConfig {
}
