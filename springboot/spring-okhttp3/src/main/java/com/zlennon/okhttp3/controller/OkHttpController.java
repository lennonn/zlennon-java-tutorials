package com.zlennon.okhttp3.controller;


import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Enumeration;

@RestController
@RequestMapping("/okhttp")
@Slf4j
public class OkHttpController {

    @RequestMapping("/readTimeout")
    public ResponseEntity timeOutFiveMinites() throws InterruptedException {
        Thread.sleep(2*60*1000);
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/queryByParam")
    public ResponseEntity<String> queryByParam(String id) {
        log.info("accept param id:{}",id);
        return new ResponseEntity(id,HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/asyncGetRequest")
    public ResponseEntity<String> asyncGetRequest() {
        return new ResponseEntity("{\"async\":\"success\"}",HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/getHeader")
    public void getHeader(HttpServletRequest request) {
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String element = names.nextElement();
            log.info("header name:{},value:{}",element,request.getHeader(element));
        }
    }

    @RequestMapping("/cancelRequest")
    public void cancelRequest(HttpServletRequest request) throws InterruptedException {
        log.info("okhttp cancel request");
        Thread.sleep(5000);
    }
    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile multipart) throws InterruptedException, IOException {

        log.info("file name is :{}", multipart.getOriginalFilename());
        byte[] read = multipart.getInputStream().readAllBytes();
        log.info(new String(read));
    }

    @RequestMapping("/postTest")
    public void postTest(String username,String password) throws InterruptedException, IOException {

        log.info("username:{},password:{}", username,password);
    }

    @RequestMapping("/postAuth")
    public void postAuth(HttpServletRequest request,@RequestBody String param) throws InterruptedException, IOException {
        String authorization = request.getHeader("Authorization");
        log.info("authorization:{},param:{}", authorization,param);
    }
}
