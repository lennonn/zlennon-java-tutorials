package com.zlennon.redismysql.config;

import com.zlennon.redismysql.MyEntryAddedListener;
import com.zlennon.redismysql.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.RedissonQueue;
import org.redisson.WriteBehindService;
import org.redisson.api.RMapCache;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.ListAddListener;
import org.redisson.api.listener.ListSetListener;
import org.redisson.api.listener.SetObjectListener;
import org.redisson.api.map.event.MapEntryListener;
import org.redisson.command.CommandAsyncService;
import org.redisson.config.Config;
import org.redisson.connection.SingleConnectionManager;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
@EnableRedisRepositories
@EnableCaching
@Slf4j
public class RedisConfig {



    @Bean
    JedisConnectionFactory jedisConnectionFactory(RedisProperties properties) {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setPassword(properties.getPassword());
        configuration.setHostName(properties.getHost());
        configuration.setPort(properties.getPort());
        return new JedisConnectionFactory(configuration) ;
    }



    @Bean
    public <K,V> RedisTemplate<K, V> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<K, V> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(jedisConnectionFactory);
        RedisSerializer<String> keySerializer = new StringRedisSerializer();
        RedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer(Object.class);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 值采用json序列化
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(keySerializer);
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(keySerializer);
        template.setHashValueSerializer(valueSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean(destroyMethod = "shutdown")
    RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
                //.setPassword("123456");
        return Redisson.create(config);
    }

    @Bean
    RQueue<Account>  accountRQueue(RedissonClient redissonClient){
        return redissonClient.getQueue("accountRQueue");
    }

    @Bean
    public RMapCache<String, Account> accountCache (RedissonClient redissonClient) {
        RMapCache<String, Account> cache = redissonClient.getMapCache("accountCache");
        //cache.addListener(new MyEntryAddedListener());
        //cache.addListener(new MyEntryAddedListener());
        return cache;
    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))

                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    CacheManager cacheManager(RedisConnectionFactory jedisConnectionFactory, RedisCacheConfiguration cacheConfiguration) {
        return new RedisCacheManager(RedisCacheWriter.lockingRedisCacheWriter(jedisConnectionFactory),cacheConfiguration);
    }

}
