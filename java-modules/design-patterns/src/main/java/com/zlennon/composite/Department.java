package com.zlennon.composite;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Department implements Organization{
    private String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void showName() {
        log.info("部门名称: " + name);
    }
}
