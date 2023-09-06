package com.zlennon.service.saga;


import com.zlennon.domain.ProductEntity;
import com.zlennon.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component("productSagaAction")
@Slf4j
public class ProductSagaActionImpl implements ProductSagaAction {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean reduceProduct(Long productId, int quantity){
        Optional<ProductEntity> product = productRepository.findById(productId);
        ProductEntity productEntity = product.get();
        if (productEntity.getQuantity()-quantity<0) {
            throw new RuntimeException("库存不足");
        }
        productEntity.setQuantity(productEntity.getQuantity()-quantity);
        productRepository.save(productEntity);
        return true;
    }

    /**
     * cancel 补偿
     * @param
     * @return
     */
    @Override
    public boolean compensateProduct(Long productId, int quantity){
        Optional<ProductEntity> product = productRepository.findById(productId);
        ProductEntity productEntity = product.get();
        productEntity.setQuantity(productEntity.getQuantity()+quantity);
        productRepository.save(productEntity);
        return true;
    }
}
