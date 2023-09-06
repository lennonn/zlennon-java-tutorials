package com.zlennon.openfeign.controller;

import com.zlennon.commonentity.ReqResItemsEntity;
import com.zlennon.openfeign.client.ChatGPTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/openfeign")
public class RequestController {

   @Autowired
   private ChatGPTClient   chatGPTClient;

    @GetMapping("getChatGPTById")
    ReqResItemsEntity getChatGPTById(@RequestParam Long id){
       return chatGPTClient.getChatGPTById(id);
   }
}
