package com.zlennon.chatgptmodelservice.controller;

import com.zlennon.chatgptmodelservice.repository.ModelRepository;
import com.zlennon.i18n.MessageUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/chatgpt")
@Slf4j
public class ModelController {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    MessageUtils messageUtils;


    @RequestMapping("/test")
    public ResponseEntity test(HttpServletRequest request, String code){
        log.info("model test");
        return new ResponseEntity(messageUtils.get(code), HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/getModelList")
    public ResponseEntity getModelList(HttpServletRequest request, String code){
        log.info("model test");
        return new ResponseEntity("body", HttpStatusCode.valueOf(200));
    }
}
