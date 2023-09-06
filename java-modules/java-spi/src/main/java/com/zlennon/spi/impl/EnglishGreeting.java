package com.zlennon.spi.impl;

import com.zlennon.spi.GreetingSPI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnglishGreeting implements GreetingSPI {
    @Override
    public void greeting() {
        System.out.println("test");
        log.info("Hello,Java SPI");
    }
}
