package com.zlennon.scheduling.async;

import java.lang.reflect.Method;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(final Throwable throwable, final Method method, final Object... obj) {
        log.info("Exception message:{},Method name,params:{}" ,throwable.getMessage(),method.getName(), Arrays.deepToString(obj));
    }

}
