package com.zlennon.service;

import java.util.Optional;

import com.zlennon.devil.ProductProcessingException;
import com.zlennon.domain.Product;
import com.zlennon.event.ProductTransactionEvent;
import com.zlennon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zlennon.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Profile("dev")
@Slf4j
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

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
            eventPublisher.publishEvent(new ProductTransactionEvent(transactionId, prod));
            if (prod.getQuantity() < quantity) {
                throw new ProductProcessingException("Insufficient product quantity. Available: " + prod.getQuantity() + ", Demand: " + quantity);
            }
            prod.setQuantity(prod.getQuantity() - quantity);
            log.info("product execute before publishEvent time:{}",System.currentTimeMillis());
            productRepository.save(ProductMapper.map(prod));
            log.info("product execute after save time:{}",System.currentTimeMillis());

        });
    }

}
