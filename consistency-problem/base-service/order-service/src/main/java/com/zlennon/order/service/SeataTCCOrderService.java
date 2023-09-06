package com.zlennon.order.service;

import com.zlennon.domain.Account;
import com.zlennon.domain.DistributedTransactionStatus;
import com.zlennon.domain.Product;
import com.zlennon.order.domain.Order;
import com.zlennon.order.feign.AccountFeign;
import com.zlennon.order.feign.ProductFeign;
import com.zlennon.order.repository.OrderRepository;
import com.zlennon.order.service.tcc.OrderTccAction;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;

@Service
@Profile("seata-tcc")
@Slf4j
public class SeataTCCOrderService implements IOrderService{

    private static final String TXN_ID_HEADER = "X-Txn-ID";

    private final Random random = new Random();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private  OrderTccAction orderTccAction;

    @Autowired
    ProductFeign productFeign;

    @Autowired
    AccountFeign accountFeign;


    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @GlobalTransactional
    @Override
    public Order createOrder(Order order) {
       // Order savedOrder = orderRepository.save(order);
        Long id= orderRepository.findMaxId()+1l;
        order.setId(id);
        boolean b = orderTccAction.prepareCreateOrder(null, order);
        //Product product = updateProduct(null,order);
        Product product=productFeign.updateQuantity(null,order.getProductId(), order.getQuantity());
        log.info("Product updated: {}", product);
        int totalAmount = product.getPrice() * order.getQuantity();

        Account account = restTemplate.getForObject("http://account-service/accounts/customer/{customerId}", Account.class, order.getCustomerId());
        log.info("Account :{}", account);
        log.info("Withdrawing money: {}", totalAmount);
       // withdraw(null,account.getId(), totalAmount);
        accountFeign.withdrawl(null,account.getId(),totalAmount);
        return order;
    }

    public Product updateProduct(String transactionId, Order order) {
        HttpEntity<Void> requestEntity = new HttpEntity<>(prepareHeaders(transactionId));
        return restTemplate.exchange(
                "http://product-service/products/{id}/quantity/{quantity}",
                HttpMethod.PUT,
                requestEntity,
                Product.class,
                order.getProductId(),
                order.getQuantity()).getBody();
    }

    public Account withdraw(String transactionId, Long accountId, int amount) {
        HttpEntity<Void> requestEntity = new HttpEntity<>(prepareHeaders(transactionId));
        return restTemplate.exchange("http://account-service/accounts/{id}/withdrawl/{amount}", HttpMethod.PUT, requestEntity, Account.class, accountId, amount).getBody();
    }

    @Override
    public void addTransactionParticipant(String transactionId, String serviceId, DistributedTransactionStatus status) {

    }

    public HttpHeaders prepareHeaders(String transactionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(TXN_ID_HEADER, transactionId);
        return headers;
    }

}
