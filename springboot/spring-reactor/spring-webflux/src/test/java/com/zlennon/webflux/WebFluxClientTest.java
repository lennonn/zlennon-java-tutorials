package com.zlennon.webflux;

import com.zlennon.webflux.controller.ModelClient;
import org.junit.Test;

public class WebFluxClientTest {

    @Test
    public void test(){

        ModelClient modelClient = new ModelClient();
        modelClient.consume();
    }
}
