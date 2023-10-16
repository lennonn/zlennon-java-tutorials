package com.zlennon.io.bytes.outputstream;

import java.io.Serializable;

public class MyObject implements Serializable {

    private String name;

    private int age;

    public MyObject(String name, int age) {
        this.age=age;
        this.name=name;
    }
}
