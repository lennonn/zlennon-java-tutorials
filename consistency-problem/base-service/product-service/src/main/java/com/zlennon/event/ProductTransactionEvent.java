package com.zlennon.event;

import com.zlennon.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductTransactionEvent {

    private String transactionId;

    private Product product;

}
