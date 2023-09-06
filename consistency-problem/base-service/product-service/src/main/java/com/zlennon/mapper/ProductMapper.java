package com.zlennon.mapper;

import com.zlennon.domain.ProductEntity;
import org.springframework.beans.BeanUtils;

import com.zlennon.domain.Product;

public class ProductMapper {

    public static Product map(ProductEntity product) {
        Product prod = new Product();
        BeanUtils.copyProperties(product, prod);
        return prod;
    }

    public static ProductEntity map(Product product) {
        ProductEntity prod = new ProductEntity();
        BeanUtils.copyProperties(product, prod);
        return prod;
    }

}
