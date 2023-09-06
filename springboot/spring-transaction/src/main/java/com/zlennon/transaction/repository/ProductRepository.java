package com.zlennon.transaction.repository;

import com.zlennon.transaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}