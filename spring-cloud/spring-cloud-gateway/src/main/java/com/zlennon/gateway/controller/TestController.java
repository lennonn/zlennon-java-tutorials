package com.zlennon.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/demoi18n")
public class TestController {


    @Autowired
    private MessageSource messageSource;

    /**
     * 通过code获取国际化内容
     * code为 messages.properties 中的 key
     *
     * 测试使用 user.register.success
     */
/*    @GetMapping("demo")
    public Mono<String> get(String code) {

        return Mono.just(messageSource.getMessage(code, new Object[]{
        }, LocaleContextHolder.getLocale()));
    }*/
}