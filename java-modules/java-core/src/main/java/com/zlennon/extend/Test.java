package com.zlennon.extend;


import org.junit.Assert;

public class Test {
    public static void main(String[] args) {
        Layout1 layout1 = new Layout1();
        layout1.setFlag(true);
        Layout2 layout2 = new Layout2();
        System.out.println(layout1.isFlag());
        System.out.println(layout2.isFlag());
        Assert.assertEquals(layout1.getExecutorService(),layout2.getExecutorService());
    }
}
