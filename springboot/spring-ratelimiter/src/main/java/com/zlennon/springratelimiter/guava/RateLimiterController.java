package com.zlennon.springratelimiter.guava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rateLimiter")
@Slf4j
@RestController
public class RateLimiterController {




    @RequestMapping("/testLimit")
    public  String  limit(){
        return "请求成功";
    }
}
