package com.zlennon.apachekafka;

import com.zlennon.apachekafka.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration()
public class ApacheKafkaApplicationTests {

    @Qualifier
    MessageService messageService;

    @Test
    void testMessageService(){
        assertNotNull(messageService);
        messageService.execute();
    }

    @Test
    void testMultiTypeMessage()  {
        assertNotNull(messageService);
        messageService.multiTypeExecute();
    }
}
//@SpringBootTest
