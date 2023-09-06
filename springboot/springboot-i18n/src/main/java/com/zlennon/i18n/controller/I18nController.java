package com.zlennon.i18n.controller;


import com.zlennon.i18n.MessageUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nController {

    @Autowired
    MessageUtils messageUtils;

    @RequestMapping("/getMessage")
    public ResponseEntity getMessage(HttpServletRequest request,String code){
        String msg = messageUtils.get(code);
        return new ResponseEntity(msg, HttpStatusCode.valueOf(200));
    }
}
