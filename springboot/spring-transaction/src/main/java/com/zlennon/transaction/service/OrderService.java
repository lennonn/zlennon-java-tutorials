package com.zlennon.transaction.service;

import com.zlennon.transaction.entity.Order;
import com.zlennon.transaction.entity.Product;
import com.zlennon.transaction.repository.OrderRepository;
import com.zlennon.transaction.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class)
    public Order cretateOrder(Order order) throws Exception {
        orderRepository.save(order);
        Optional<Product> byId = productRepository.findById(order.getProductId());
        Product product = byId.get();
        if(product.getQuantity()-order.getQuantity()<0){
            throw new Exception("产品已售罄！");
        }
        product.setQuantity(product.getQuantity()-order.getQuantity());
        productRepository.save(product);
        return order;
    }
}
