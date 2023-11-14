package com.zlennon.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Company implements Organization{
    private String name;
    private List<Organization> children = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void add(Organization component) {
        children.add(component);
    }

    public void remove(Organization component) {
        children.remove(component);
    }

    @Override
    public void showName() {
        log.info("公司名字: " + name);
        for (Organization component : children) {
            component.showName();
        }
    }
}
