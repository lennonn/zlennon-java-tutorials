package com.zlennon.strategy;

public class StrategyOther implements Strategy {

    @Override
    public void apply(Integer type) {
        System.out.println(type);
    }
}
