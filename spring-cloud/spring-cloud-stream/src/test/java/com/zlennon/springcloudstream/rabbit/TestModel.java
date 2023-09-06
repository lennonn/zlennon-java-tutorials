package com.zlennon.springcloudstream.rabbit;


import com.zlennon.springcloudstream.SpringCloudStreamApplication;
import com.zlennon.springcloudstream.rabbit.deprecated.ModelInfoSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudStreamApplication.class)
public class TestModel {

    @Autowired
    ModelInfoSender modelInfoSender;

    @Test
    public void test(){
        modelInfoSender.send();
    }
}
