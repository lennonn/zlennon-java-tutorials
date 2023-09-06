package com.zlennon.order.service;

import com.zlennon.domain.Account;
import com.zlennon.domain.DistributedTransactionStatus;
import com.zlennon.domain.Product;
import com.zlennon.order.domain.Order;
import com.zlennon.order.feign.AccountFeign;
import com.zlennon.order.feign.ProductFeign;
import com.zlennon.order.repository.OrderRepository;
import com.zlennon.order.service.saga.OrderSagaAction;
import com.zlennon.order.service.tcc.OrderTccAction;
import io.seata.saga.engine.StateMachineEngine;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@Profile("seata-saga")
@Slf4j
public class SeataSagaOrderService implements IOrderService{

    @Autowired
    ProductFeign productFeign;

    @Autowired
    AccountFeign accountFeign;

    @Autowired
    OrderSagaAction orderSagaAction;

    @Autowired
    StateMachineEngine stateMachineEngine;


    @Override
    public Order createOrder(Order order) {
        //Long id= orderRepository.findMaxId()+1l;
       // order.setId(id);
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("productId", order.getProductId());
        paramMap.put("quantity", order.getQuantity());
        paramMap.put("customerId", order.getCustomerId());
        Product product = productFeign.getProductById(order.getProductId());
        paramMap.put("amount", product.getPrice()*order.getQuantity());
        stateMachineEngine.start("CreateOrder","", paramMap);
        return order;
    }
}
