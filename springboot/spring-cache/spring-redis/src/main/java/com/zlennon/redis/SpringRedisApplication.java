package com.zlennon.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication(scanBasePackages = "com.zlennon.**.**")
public class SpringRedisApplication  implements CommandLineRunner {

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	IdWorderComponent worderComponent;

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		redisTemplate.opsForValue().set("test","1");
		redisTemplate.opsForHash().put("hashKey","key1","test redis");
		redisTemplate.opsForHash().put("hashKey","key2","object");
		worderComponent.nextStringId();
	}
}
