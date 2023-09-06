package com.zlennon.springframwork.hook;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;


@Component
public class DisposableBeanImpl implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Callback triggered - DisposableBeanImpl destroy");
    }
}
