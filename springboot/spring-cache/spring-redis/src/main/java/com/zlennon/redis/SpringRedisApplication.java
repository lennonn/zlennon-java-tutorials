package com.zlennon.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisApplication  implements CommandLineRunner {

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	IdWorderComponent idWorderComponent;

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i <10 ; i++) {

			System.out.println(idWorderComponent.nextStringId());;
		}
		redisTemplate.opsForValue().set("test","1");
		redisTemplate.opsForHash().put("hashKey","user1","user1");
		redisTemplate.opsForHash().put("hashKey","user2","user2");
		System.out.println(redisTemplate.opsForHash().get("hashKey","user2"));
	}
}
