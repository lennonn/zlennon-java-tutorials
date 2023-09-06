package com.zlennon.springautoconfig;

import lombok.Data;

@Data
public class MyService {
    boolean autoConfig;
    public MyService(boolean autoConfig) {
        this.autoConfig=autoConfig;
    }
}
