package com.zlennon.order.service.saga;


import com.zlennon.order.domain.Order;
import com.zlennon.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component("orderSagaAction")
@Slf4j
public class OrderSagaActionImpl implements OrderSagaAction {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean placeOrder(Long productId,Integer quantity,Long customerId){
        Order order =new Order();
        order.setQuantity(quantity);
        order.setProductId(productId);
        order.setCustomerId(customerId);
        orderRepository.save(order);
        return true;
    }

    /**
     * cancel 补偿
     * @param
     * @return
     */
    @Override
    public boolean compensateOrder(Long productId,Integer quantity,Long customerId){
        Order order =new Order();
        order.setQuantity(quantity);
        order.setProductId(productId);
        order.setCustomerId(customerId);
        orderRepository.delete(order);
        return true;
    }
}
