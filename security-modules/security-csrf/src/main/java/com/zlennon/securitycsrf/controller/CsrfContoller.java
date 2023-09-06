package com.zlennon.securitycsrf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/csrf")
public class CsrfContoller {

    @RequestMapping("/test")
    public String register(Model model){
        model.addAttribute("name", "csrf demo");
        return "csrf";
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name", "csrf demo");
        return "index";
    }
}

