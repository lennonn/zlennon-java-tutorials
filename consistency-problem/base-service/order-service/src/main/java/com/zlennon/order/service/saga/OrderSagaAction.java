package com.zlennon.order.service.saga;


import com.zlennon.order.domain.Order;

public interface OrderSagaAction {




    boolean placeOrder(Long productId,Integer quantity,Long customerId);

    /**
     * cancel 补偿
     * @param
     * @return
     */
    boolean compensateOrder(Long productId,Integer quantity,Long customerId);
}
