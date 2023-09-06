package com.zlennon.order.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderTransactionEvent {

    private String transactionId;

}
