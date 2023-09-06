package com.zlennon.springintegration.basic.helloworld;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InboundChannelAdapterTest {

    Logger logger = LoggerFactory.getLogger(InboundChannelAdapterTest.class);

    @Test
    public void testLogger(){
        for (int i = 0; i < 100; i++) {
            logger.info("testLogger i==>:{}",i);
        }
    }
}
