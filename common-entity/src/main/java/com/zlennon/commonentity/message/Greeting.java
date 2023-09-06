package com.zlennon.commonentity.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Greeting {

    public Greeting() {

    }

    public Greeting(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }
    private String msg;
    private String name;

}
