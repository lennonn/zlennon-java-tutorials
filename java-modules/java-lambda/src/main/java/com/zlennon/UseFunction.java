package com.zlennon;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;


@Slf4j
public class UseFunction {


    @Test
    public void funApply(){
        Function<String, String> function = a -> a.toUpperCase();
        log.info(function.apply("hello"));

    }
}
