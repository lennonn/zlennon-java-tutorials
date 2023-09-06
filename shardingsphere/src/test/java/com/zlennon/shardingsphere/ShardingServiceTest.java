package com.zlennon.shardingsphere;

import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest()
@ActiveProfiles("shardingMarking")
public class ShardingServiceTest {

        @Autowired
        ShardingService shardingService;

        @Test
       public void  testShardingInsert(){
                for (int i = 0; i <4;i++){
                    JSONObject obj = new JSONObject();
                    obj.put("data",i);
                    String req = obj.toString();
                    String res = obj.toString();
                    int type = i%2;
                    shardingService.shardingInsert(req,res,type);
                }
        }
        @Test
       public void testShardingSearch(){
            shardingService.shardingSearch();
        }
}
