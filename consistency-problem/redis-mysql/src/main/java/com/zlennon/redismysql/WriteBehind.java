package com.zlennon.redismysql;

import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * 以缓存为中心，读取时如果缓存没有从数据库获取，并保存到缓存钟，更新时先设置到缓存，然后异步更新数据库
 */

@Slf4j
@Component
@EnableScheduling
public class WriteBehind {
    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    RedisTemplate redisTemplate;

    
    private final String cache_key="account";
    @Autowired
    RQueue<Account> accountRQueue;


    public Account getAccountById(Integer id) {
        if(redisTemplate.opsForValue().get(cache_key+"::"+id)!=null){
            return  (Account)redisTemplate.opsForValue().get(cache_key+"::"+id);
        }else{
            Optional<Account> byId = accountRepository.findById(id);
            byId.ifPresent(account -> redisTemplate.opsForValue().set(cache_key + "::" + id, account));
            return byId.get();
        }
    }

    public void evictAccountCache(Integer id) {
        redisTemplate.delete(cache_key + "::" + id);
    }

    public void updateAccount(Account account) {
        redisTemplate.opsForValue().set(cache_key+"::"+account.getId(),account);
        accountRQueue.add(account);
    }


    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    public void persist() {
        log.info("持久开始。。");
        while(!accountRQueue.isEmpty()){
            Account pool = accountRQueue.poll();
            if(pool!=null){
                accountRepository.save(pool);
            }
        }
    }

}
