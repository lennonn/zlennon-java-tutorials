package com.zlennon.oauth2resource.controller;


import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@RestController
public class UserInfoController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/userinfo")
    @ResponseBody
    public Object  getUserInfo(HttpServletRequest request, Principal principal, Authentication authentication) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", request.getHeader("Authorization"));
        Object forObject = restTemplate.postForObject("http://localhost:8500/userinfo",new HttpEntity<>(headers),Object.class);
        if(principal==null) return "userinfo not exist";
        return forObject;
    }
}
