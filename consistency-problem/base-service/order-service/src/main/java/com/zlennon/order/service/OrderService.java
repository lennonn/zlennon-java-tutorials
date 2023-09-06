package com.zlennon.order.service;

import com.zlennon.domain.*;
import com.zlennon.order.devil.InSufficientFundException;
import com.zlennon.order.domain.Order;
import com.zlennon.order.event.OrderTransactionEvent;
import com.zlennon.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;

@Service
@Profile("dev")
@Slf4j
public class OrderService implements IOrderService{

    private static final String TXN_ID_HEADER = "X-Txn-ID";

    private final Random random = new Random();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Transactional
    public Order createOrder(Order order) {
        DistributedTransaction transaction = restTemplate.postForObject("http://transaction-server/transactions", new DistributedTransaction(), DistributedTransaction.class);
        log.info("Trasaction created: {}", transaction);
        Order savedOrder = orderRepository.save(order);
        Product product = updateProduct(transaction.getId(), savedOrder);
        log.info("Product updated: {}", product);
        int totalAmount = product.getPrice() * order.getQuantity();
        Account account = restTemplate.getForObject("http://account-service/accounts/customer/{customerId}", Account.class, order.getCustomerId());
        log.info("Account :{}", account);
        if (account.getBalance() >= totalAmount) {
            log.info("Withdrawing money: {}", totalAmount);
            withdraw(transaction.getId(), account.getId(), totalAmount);
        } else {
            throw new InSufficientFundException("Insufficient funds. Balance: " + account.getBalance() + ", orderAmount:  " + totalAmount);
        }
        eventPublisher.publishEvent(new OrderTransactionEvent(transaction.getId()));
        int number = random.nextInt();
/*        if (number % 2 == 0) {
            throw new OrderProcessingException("Error while processing your order");
        }*/
        return savedOrder;
    }

      public Product updateProduct(String transactionId, Order order) {
        addTransactionParticipant(transactionId, "product-service", DistributedTransactionStatus.NEW);
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
        addTransactionParticipant(transactionId, "account-service", DistributedTransactionStatus.NEW);
        HttpEntity<Void> requestEntity = new HttpEntity<>(prepareHeaders(transactionId));
        return restTemplate.exchange("http://account-service/accounts/{id}/withdrawl/{amount}", HttpMethod.PUT, requestEntity, Account.class, accountId, amount).getBody();
    }
    
     public void addTransactionParticipant(String transactionId, String serviceId, DistributedTransactionStatus status) {
        HttpEntity<DistributedTransactionParticipant> requestEntity = new HttpEntity<>(new DistributedTransactionParticipant(serviceId, status));
        restTemplate.exchange("http://transaction-server/transactions/{id}/participants", HttpMethod.PUT, requestEntity, Object.class, transactionId);
    }

     public HttpHeaders prepareHeaders(String transactionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(TXN_ID_HEADER, transactionId);
        return headers;
    }

}
