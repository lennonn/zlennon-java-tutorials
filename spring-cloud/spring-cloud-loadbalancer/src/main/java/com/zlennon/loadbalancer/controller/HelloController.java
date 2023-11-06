package com.zlennon.loadbalancer.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping ("/webclient")
    public ResponseEntity webclient(HttpServletRequest request) {
        WebClient loadBalancedClient = webClientBuilder.build();
        List<String> resp = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            String response =
                    loadBalancedClient.get().uri("http://instance-server/hello")
                            .attribute("sessionId",request.getParameter("sessionId"))
                            .retrieve().toEntity(String.class)
                            .block().getBody();
            resp.add(response);
        }
        
        return new ResponseEntity<>(resp,HttpStatusCode.valueOf(200));
    }

    @GetMapping ("/rest")
    public ResponseEntity rest(HttpServletRequest request) {
        WebClient loadBalancedClient = webClientBuilder.build();
        List<String> resp = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            String response = restTemplate.getForObject("http://instance-server/hello", String.class);
            resp.add(response);
        }

        return new ResponseEntity<>(resp,HttpStatusCode.valueOf(200));
    }
}
