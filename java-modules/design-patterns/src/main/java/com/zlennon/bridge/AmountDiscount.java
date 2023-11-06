package com.zlennon.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// 固定金额的优惠额
public class AmountDiscount implements DiscountType {
    @Override
    public void applyDiscount(double amount) {
        log.info("应付金额: " + amount);
    }
}