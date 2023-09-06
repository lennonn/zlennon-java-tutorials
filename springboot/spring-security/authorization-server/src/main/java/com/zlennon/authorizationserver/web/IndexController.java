package com.zlennon.authorizationserver.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        return "index";
    }
}
