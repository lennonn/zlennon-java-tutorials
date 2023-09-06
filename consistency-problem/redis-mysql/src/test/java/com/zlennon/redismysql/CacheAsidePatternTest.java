package com.zlennon.redismysql;


import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = RedisMysqlApplication.class)
public class CacheAsidePatternTest {
    private static redis.embedded.RedisServer redisServer;

    @Autowired
    CacheAsidePattern cacheAsidePattern;


    @Autowired
    RedisTemplate redisTemplate;

    @SpyBean
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
    public void testUpdateAccont(){

        Account account = cacheAsidePattern.updateAccount("cacheAsidePattern", 1000);
        int id = account.getId();


        account.setAmount(100000);
        Account account2 = cacheAsidePattern.updateAccount(account);

        Account accountInfo = cacheAsidePattern.getAccountInfo(account2.getCardId());

        assertThat(accountInfo.getAmount()).isEqualTo(100000);

        verify(accountRepository,times(2)).findOne(any());
    }


}
