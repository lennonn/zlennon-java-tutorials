package com.zlennon.chatgptmodelservice;


import com.zlennon.chatgptmodelservice.service.ChatModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestChatModelService {

    @Autowired
    ChatModelService chatModelService;

    @Test
    public void testListAllModel(){
        chatModelService.execute();
    }
}
