package com.zlennon.redismysql;


import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServerBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
//@SpringBootTest(classes = RedisMysqlApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = RedisMysqlApplication.class)
public class ReadWriteThroughTest {
    private static redis.embedded.RedisServer redisServer;

    @Autowired
    ReadWriteThrough readWriteThrough;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeClass
    public static void startRedisServer() throws IOException {
      // redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 256M").build();
      // redisServer.start();
    }

    @AfterClass
    public static void stopRedisServer() throws IOException {
      // redisServer.stop();
    }

    @Test
    public void testCacheable(){
        int id=1;
        Account accountById = readWriteThrough.getAccountById(id);

       // redisTemplate.opsForValue().get("account::1");
        Account accountById2 = readWriteThrough.getAccountById(id);
        //assertThat(accountById).isEqualTo(accountById2);
        verify(accountRepository, times(1)).findById(id);
    }


    @Test
    public void testCachePut(){

        Account account = new Account(3,"testCachePut",20f);

        Account account1 = readWriteThrough.updateAccount(account);
        Account cacheAccount = (Account) redisTemplate.opsForValue().get("account::" + account1.getId());
        assertThat(account1).isEqualTo(cacheAccount);

    }

    @Test
    public void testCacheEvict(){

        readWriteThrough.deleteAccount(3);
        Account cacheAccount = (Account) redisTemplate.opsForValue().get("account::3");
        assertThat(cacheAccount).isNull();

    }

}
