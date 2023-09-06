package com.zlennon.service;

import com.zlennon.devil.ProductProcessingException;
import com.zlennon.domain.Product;
import com.zlennon.mapper.ProductMapper;
import com.zlennon.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Profile("seata-at")
@Slf4j
public class SeataATProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public Product createProduct(Product product) {
        return ProductMapper.map(productRepository.save(ProductMapper.map(product)));
    }

    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId).map(ProductMapper::map);
    }

    @Async
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateQuantity(String transactionId, Long productId, int quantity) {
        log.info("Updating product quantity with id: {}, quantity: {}", productId, quantity);

        findById(productId).ifPresent(prod -> {
            if (prod.getQuantity() < quantity) {
                throw new ProductProcessingException("Insufficient product quantity. Available: " + prod.getQuantity() + ", Demand: " + quantity);
            }
            prod.setQuantity(prod.getQuantity() - quantity);
             productRepository.save(ProductMapper.map(prod));
        });

    }


}
