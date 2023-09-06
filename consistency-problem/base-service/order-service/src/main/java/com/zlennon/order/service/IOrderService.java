package com.zlennon.order.service;

import com.zlennon.domain.Account;
import com.zlennon.domain.DistributedTransactionStatus;
import com.zlennon.domain.Product;
import com.zlennon.order.domain.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public interface IOrderService {


    default Order createOrder(Order order) {
        return null;
    }

    default Optional<Order> getOrderById(Long orderId) {
        return null;
    }

    default Product updateProduct(String transactionId, Order order) {
        return null;
    }

    default Account withdraw(String transactionId, Long accountId, int amount) {
        return null;
    }

    default void addTransactionParticipant(String transactionId, String serviceId, DistributedTransactionStatus status) {
    }

    default HttpHeaders prepareHeaders(String transactionId) {
        return null;
    }

}
