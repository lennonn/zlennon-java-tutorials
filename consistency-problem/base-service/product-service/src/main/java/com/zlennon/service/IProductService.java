package com.zlennon.service;

import com.zlennon.devil.ProductProcessingException;
import com.zlennon.domain.Product;
import com.zlennon.event.ProductTransactionEvent;
import com.zlennon.mapper.ProductMapper;
import com.zlennon.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface IProductService {


    default Product createProduct(Product product) {
        return null;
    }

    default  Optional<Product> findById(Long productId) {
        return null;
    }

    default void updateQuantity(String transactionId, Long productId, int quantity) {

    }

}
