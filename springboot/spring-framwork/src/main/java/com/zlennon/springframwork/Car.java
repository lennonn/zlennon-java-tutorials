package com.zlennon.springframwork;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car {
    private String name;
    private String color;
    public Car(){
        this.name="constructor";
        this.color="constructor";
    }

    private void initCar() {
        this.name="initCar";
        this.color="initCar";
    }
}
