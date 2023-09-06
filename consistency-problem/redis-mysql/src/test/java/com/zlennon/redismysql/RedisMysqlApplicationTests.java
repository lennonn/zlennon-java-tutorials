package com.zlennon.redismysql;

import com.zlennon.redismysql.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
class RedisMysqlApplicationTests {

    @Autowired
    private CacheAsidePattern cacheAsidePattern;

    private String card="test11";
    @Test
    void testCredit() {
        Account account = cacheAsidePattern.updateAccount(card, 100d);
        assertEquals(200d,account.getAmount());
    }

    @Test
    void testAetAccountInfo(){
        Account accountInfo = cacheAsidePattern.getAccountInfo(card);
        assertEquals(accountInfo.getAmount(), 100d);
    }


}
