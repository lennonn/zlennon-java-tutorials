package com.zlennon.securityvul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
@Slf4j
public class SecurityController {


    @RequestMapping("/xss")
    public Object xss(String params) {
        return "security";
    }
}
