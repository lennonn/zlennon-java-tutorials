package com.zlennon.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class IdWorderComponent {

	public static String snowId = "";

	private SnowflakeIdFactory snowflakeIdFactory;

	public IdWorderComponent(RedisTemplate redisTemplate) {

		List<String> keyList = Arrays.asList("SNOW_ID", "USED_SNOW_ID");
		String argsone = "none";
		Object result = "";
		try {
			DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
			redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/id.lua")));
			redisScript.setResultType(String.class);

			result = redisTemplate.execute(redisScript, keyList, argsone);

			if (StringUtils.isNotEmpty(result.toString())) {
				snowId = result.toString();
			}
		} catch (Exception e) {
			log.error("RedisLuaUtil错误:", e);
		}
		Random random = new Random();
		int r1 = random.nextInt(29) + 1;
		int r2 = random.nextInt(29) + 1;

		long worderId = RandomUtils.nextLong(1,31);
		long detacenterId = RandomUtils.nextLong(1,31);

		this.snowflakeIdFactory = new SnowflakeIdFactory(worderId, detacenterId);
	}

	public String nextStringId() {
		return String.valueOf(snowflakeIdFactory.nextId());
	}

	public long nextLongId() {
		return snowflakeIdFactory.nextId();
	}
}
