package com.zlennon.netty.transport.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

public class BootstrapFunctionTest {
    private static BootstrapFunction bootstrapFunction;

    @Before
    public void init() throws Exception {
        bootstrapFunction = new BootstrapFunction();
    }
    @Test
    public void testConfig(){
        bootstrapFunction.config();
    }
}
