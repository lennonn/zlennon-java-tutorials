package com.zlennon.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//根据购物金额的折扣
public class TieredDiscount implements DiscountType {
    @Override
    public void applyDiscount(double amount) {
        double discount;
        if (amount < 100) {
            discount = 0.05;
        } else if (amount < 200) {
            discount = 0.1;
        } else {
            discount = 0.15;
        }
        log.info("应付金额: " + (amount * (1 - discount)));
    }
}

