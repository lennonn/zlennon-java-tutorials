package com.zlennon.bridge;

public class PercentageCoupon implements Coupon {
    private DiscountType discountType;
    private double percentage;

    public PercentageCoupon(DiscountType discountType, double percentage) {
        this.discountType = discountType;
        this.percentage = percentage;
    }

    @Override
    public void applyCoupon(double amount) {
        discountType.applyDiscount(amount * (1 - percentage));
    }
}
