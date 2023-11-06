package com.zlennon.bridge;

public class FixedAmountCoupon implements Coupon {
    private DiscountType discountType;
    private double fixedAmount;

    public FixedAmountCoupon(DiscountType discountType, double fixedAmount) {
        this.discountType = discountType;
        this.fixedAmount = fixedAmount;
    }

    @Override
    public void applyCoupon(double amount) {
        discountType.applyDiscount(amount - fixedAmount);
    }
}
