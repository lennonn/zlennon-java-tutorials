package com.zlennon.service;

import com.zlennon.domain.Product;
import com.zlennon.mapper.ProductMapper;
import com.zlennon.repository.ProductRepository;
import com.zlennon.service.saga.ProductSagaAction;
import com.zlennon.service.tcc.ProductTccAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("seata-saga")
@Slf4j
public class SeataSagaProductService implements IProductService{


    @Autowired
    ProductSagaAction productSagaAction;

    @Autowired
    ProductRepository productRepository;




    public boolean reduceProduct(Long productId, int quantity) {
      return  productSagaAction.reduceProduct(productId,quantity);
    }

    public boolean compensateProduct(Long productId, int quantity) {
      return   productSagaAction.compensateProduct(productId,quantity);
    }

    public Product getProductById(Long productId) {
       return  productRepository.findById(productId).map(ProductMapper::map).get();
    }
}
