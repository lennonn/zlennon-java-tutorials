package com.zlennon.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class IdWorderComponent {

	public static String snowId = "";

	private SnowflakeIdFactory snowflakeIdFactory;

	@Value("${sf.worderId:0}")
	long worderId;

	@Value("${sf.detacenterId:1}")
	long detacenterId;

	public IdWorderComponent(RedisTemplate redisTemplate) {

		Random random = new Random();
		int r1 = random.nextInt(29) + 1;
		int r2 = random.nextInt(29) + 1;

		this.snowflakeIdFactory = new SnowflakeIdFactory(Long.valueOf(0), Long.valueOf(32));
	}

	public String nextStringId() {
		return String.valueOf(snowflakeIdFactory.nextId());
	}

	public long nextLongId() {
		return snowflakeIdFactory.nextId();
	}
}
