package com.zlennon.spi;

import java.util.ServiceLoader;

public class SPIDemo {

    public static void main(String[] args) {
       testSPILoad();
    }

    public static void testSPILoad() {
        ServiceLoader<GreetingSPI> serviceLoader = ServiceLoader.load(GreetingSPI.class);

        for(GreetingSPI greetingSPI :serviceLoader)
        {
            greetingSPI.greeting();
        }
    }

}
