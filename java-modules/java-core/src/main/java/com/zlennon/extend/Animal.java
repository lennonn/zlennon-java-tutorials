package com.zlennon.extend;

import java.util.List;

public class Animal {
    private  List<? extends Cat> cats;
    public Animal(List<? extends Cat> cats){
        this.cats = cats;
    }

    public List<? extends Cat> getCats() {
        return cats;
    }

    public void setCats(List<? extends Cat> cats) {
        this.cats = cats;
    }
}
