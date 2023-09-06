package com.zlennon.spi.impl;

import com.zlennon.spi.GreetingSPI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChineseGreeting implements GreetingSPI {
    @Override
    public void greeting() {
        log.info("你好，Java SPI");
    }
}
