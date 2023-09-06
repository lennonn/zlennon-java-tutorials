package com.zlennon.redismysql;

import com.alibaba.fastjson2.JSONObject;
import com.google.gson.JsonObject;
import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 旁路缓存模式
 * Cache Aside Pattern 中服务端需要同时维系 DB 和 cache，并且是以 DB 的结果为准。
 */
@Component
public class CacheAsidePattern {

        @Autowired
        private AccountRepository accountRepository;
        @Autowired
        private RedisTemplate<String,Object> redisTemplate;

        private static final String accountKey="account::";

        public Account  getAccountInfo(String cardId){
                if(redisTemplate.opsForHash().hasKey(accountKey,cardId)){
                        Account account = (Account) redisTemplate.opsForHash().get(accountKey, cardId);
                        return account;
                }
                Account account = new Account();
                account.setCardId(cardId);
                ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("amount");
                Example<Account> example = Example.of(account,matcher);
                Account account1 = accountRepository.findOne(example).orElse(null);
                redisTemplate.opsForHash().put(accountKey,cardId,account1);
                return account1;

        }


        public Account  updateAccount(String cardId,double amount){
                Account account = getAccountInfo(cardId);
                if(account==null) {
                        account = new Account(cardId);
                }
                account.credit(amount);
                Account save = accountRepository.save(account);
                redisTemplate.opsForHash().delete(accountKey,cardId);
                return save;
        }

        public Account  updateAccount(Account account){
                Account save = accountRepository.save(account);
                redisTemplate.opsForHash().delete(accountKey,account.getCardId());
                return save;
        }

}
