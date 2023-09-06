package com.zlennon.order.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Order Service", description = "REST API for CRUD operation", version = "1.0"))
public class OpenApiConfig {

}
