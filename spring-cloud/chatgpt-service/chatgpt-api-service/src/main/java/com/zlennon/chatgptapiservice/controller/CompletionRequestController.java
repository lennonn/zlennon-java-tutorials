package com.zlennon.chatgptapiservice.controller;

import com.alibaba.fastjson2.JSONObject;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.service.OpenAiService;
import com.zlennon.chatgptapiservice.model.ReqResItemsEntity;
import com.zlennon.chatgptapiservice.repository.ReqResItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatgpt")
@Slf4j
public class CompletionRequestController {

    @Value("${token}")
    private String token;

    @Autowired
    private ReqResItemsRepository reqResItemsRepository;

    @RequestMapping("/completion")
    public Object completionRequest(@RequestBody  String params) {
        CompletionRequest completionRequest = JSONObject.parseObject(params, CompletionRequest.class);
        OpenAiService service = new OpenAiService(token);
        log.info("Creating completion...");
        List<CompletionChoice> choices = service.createCompletion(completionRequest).getChoices();
        ReqResItemsEntity resItemsEntity = new ReqResItemsEntity();
        resItemsEntity.setApi("/v1/completions");
        resItemsEntity.setReqInfo(JSONObject.parseObject(params).toString());
        resItemsEntity.setResInfo(JSONObject.toJSONString(choices));
        resItemsEntity.setType(1);
        reqResItemsRepository.save(resItemsEntity);
        log.info("save resItemsEntity finished...");
        return ResponseEntity.ok(choices.toArray());
    }

    @GetMapping("/image")
    public Object imageRequest(@RequestBody  String params) {
        CreateImageRequest  createImageRequest = JSONObject.parseObject(params, CreateImageRequest.class);
        OpenAiService service = new OpenAiService(token);
        ImageResult imageResult = service.createImage(createImageRequest);
        ReqResItemsEntity resItemsEntity = new ReqResItemsEntity();
        resItemsEntity.setApi("/v1/images/generations");
        resItemsEntity.setReqInfo(JSONObject.parseObject(params).toString());
        resItemsEntity.setResInfo(JSONObject.toJSONString(imageResult));
        resItemsEntity.setType(2);
        reqResItemsRepository.save(resItemsEntity);
        return ResponseEntity.ok(imageResult);
    }

/*
    @GetMapping("/image")
    public Object transcriptionsRequest(@RequestBody  String params) {
        CreateTranscriptionRequest  createImageRequest = JSONObject.parseObject(params, CreateTranscriptionRequest.class);
        OpenAiService service = new OpenAiService(token);
        ImageResult imageResult = service.createImage(createImageRequest);
        ReqResItemsEntity resItemsEntity = new ReqResItemsEntity();
        resItemsEntity.setApi("/v1/images/generations");
        resItemsEntity.setReqInfo(JSONObject.parseObject(params).toString());
        resItemsEntity.setResInfo(JSONObject.toJSONString(imageResult));
        resItemsEntity.setType(2);
        reqResItemsRepository.save(resItemsEntity);
        return ResponseEntity.ok(imageResult);
    }
*/


    @RequestMapping("/getChatGPTById/{modelId}")
    public Object getChatGPTById (@PathVariable String modelId){
        OpenAiService service = new OpenAiService(token);
        return   service.getModel(modelId);
    }

    @RequestMapping("/getAllModel")
    public Object getAllModel (){
        OpenAiService service = new OpenAiService(token);
        return service.listModels();
    }
}