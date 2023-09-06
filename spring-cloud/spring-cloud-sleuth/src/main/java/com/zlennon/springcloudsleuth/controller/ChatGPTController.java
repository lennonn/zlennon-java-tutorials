package com.zlennon.springcloudsleuth.controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/sleuth")
public class ChatGPTController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("completionRequest")
    public void completionRequest(){
        log.info("start completionRequest time:{}",System.currentTimeMillis());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model","text-embedding-ada-002");
        jsonObject.put("prompt","窗前明月光");
        jsonObject.put("user","testing");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info("request param:{}",jsonObject.toJSONString());
        HttpEntity<String> request = new HttpEntity<String>(jsonObject.toJSONString(),headers);
        //
        String url ="http://127.0.0.1:9999/chatgpt/completion";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        log.info("response status:{}",response.getStatusCodeValue());
        System.out.println(response.getBody());
        if(response.getStatusCodeValue()==200) {
            String body = response.getBody();
        }
    }
}
