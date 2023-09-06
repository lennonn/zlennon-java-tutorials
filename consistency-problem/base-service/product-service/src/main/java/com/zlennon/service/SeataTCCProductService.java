package com.zlennon.service;

import com.zlennon.domain.Product;
import com.zlennon.mapper.ProductMapper;
import com.zlennon.repository.ProductRepository;
import com.zlennon.service.tcc.ProductTccAction;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Profile("seata-tcc")
@Slf4j
public class SeataTCCProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductTccAction productTccAction;


    public Product createProduct(Product product) {
        return ProductMapper.map(productRepository.save(ProductMapper.map(product)));
    }

    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId).map(ProductMapper::map);
    }

    public void updateQuantity(String transactionId, Long productId, int quantity) {
        log.info("Updating product quantity with id: {}, quantity: {}", productId, quantity);

        productTccAction.prepareDecreaseStorage(null,productId,quantity);

    }


}
