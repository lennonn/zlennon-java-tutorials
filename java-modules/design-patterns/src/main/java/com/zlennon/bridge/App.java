package com.zlennon.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class App implements DiscountType {
    public static void main(String[] args) {
        DiscountType discountType = new AmountDiscount();
        DiscountType tieredType = new TieredDiscount();
        Coupon fixedAmountCoupon = new FixedAmountCoupon(discountType, 10);
        Coupon percentageCoupon = new PercentageCoupon(discountType, 0.25);
        Coupon tieredPercentageCoupon = new PercentageCoupon(tieredType, 0.1);

        log.info("固定金额优惠券:");
        fixedAmountCoupon.applyCoupon(100);

        log.info("百分比优惠券:");
        percentageCoupon.applyCoupon(100);

        //折上折
        log.info("根据金额计算折扣优惠券:");
        tieredPercentageCoupon.applyCoupon(100);
    }
}
