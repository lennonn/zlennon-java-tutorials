package com.zlennon.springsession.redis;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @RequestMapping("/hello")
    public String helloAdmin() {
        return "hello admin";
    }

    @RequestMapping("/getSessionInfo")
    public String getSessionInfo(String sessionId) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(sessionId);
        return JSONObject.toJSONString(entries);
    }
}
