package com.zlennon.extend;

public class EmptyCalculate3d extends AbtractCalculate {
    Calculate2d calculate2d =new Calculate2d();
    public void test(){
        super.avg();
        calculate2d.avg();
    }
}
