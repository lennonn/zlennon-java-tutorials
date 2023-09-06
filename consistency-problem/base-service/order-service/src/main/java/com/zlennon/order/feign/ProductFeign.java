package com.zlennon.order.feign;


import com.zlennon.domain.Product;
import com.zlennon.order.config.SeataInterceptor;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value="product-service",path = "/products",configuration = {FeignErrorDecoder.class, SeataInterceptor.class})
@Component
public interface ProductFeign {
    @PutMapping("/{id}/quantity/{quantity}")
    Product updateQuantity( @RequestHeader(value = "xid") String xid, @PathVariable(value="id")Long productId, @PathVariable(value="quantity")int quantity);

    @GetMapping("/seata/{id}/getProductById")
    Product getProductById(@PathVariable(value="id")Long productId);


    @PutMapping("/seata/{id}/reduceProduct/{quantity}")
    public boolean reduceProduct(@PathVariable("id") Long productId, @PathVariable("quantity") int quantity) throws Exception;

    @PutMapping("/seata/{id}/compensateProduct/{quantity}")
    @Operation(summary = "Find product by ID")
    public boolean compensateProduct(@PathVariable("id") Long productId, @PathVariable("quantity") int quantity) throws Exception;
}
