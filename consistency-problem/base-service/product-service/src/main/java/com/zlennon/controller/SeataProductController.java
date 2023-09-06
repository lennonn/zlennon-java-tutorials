package com.zlennon.controller;

import com.zlennon.devil.ProductNotFoundException;
import com.zlennon.domain.Product;
import com.zlennon.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * Exposes REST API Interface for interacting with ProductService.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@RestController
@RequestMapping("/products/seata")
@Tag(name = "Products")
@Profile("seata-saga")
public class SeataProductController {

    @Autowired
    private SeataSagaProductService productService;



    @GetMapping("/{id}/getProductById")
    Product getProductById(@PathVariable(value="id")Long productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/{id}/reduceProduct/{quantity}")
    public boolean reduceProduct(@PathVariable("id") Long productId, @PathVariable("quantity") int quantity) {
        return productService.reduceProduct(productId,quantity);
    }

    @PutMapping("/{id}/compensateProduct/{quantity}")
    @Operation(summary = "Find product by ID")
    public boolean compensateProduct(@PathVariable("id") Long productId, @PathVariable("quantity") int quantity) {
        return productService.compensateProduct(productId, quantity);
    }

}
