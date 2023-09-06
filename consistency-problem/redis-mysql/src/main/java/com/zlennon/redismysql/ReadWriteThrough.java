package com.zlennon.redismysql;

import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Slf4j
/**
 * 读写穿透
 * 读取不到的话，先从 DB 加载，写入到 cache 后返回响应。
 */
@Component
public class ReadWriteThrough{

    @Autowired
    private AccountRepository accountRepository;

    @Cacheable(value = "account", key = "#id")
    public Account getAccountById(Integer id) {
        // 如果缓存中不存在该对象，则从数据库中加载该对象
        Account account = accountRepository.findById(id).orElse(null);
        log.info("查询数据库返回:{}",account==null?"data not found!":account.toString());
        return account;
    }

   //先写数据库，将返回值写道缓存中
    @CachePut(value = "account", key = "#account.id")
    public Account updateAccount(Account account) {
        // 更新数据库中的数据
        accountRepository.save(account);
        return account;
    }


    //先删除数据库，然后删除缓存
    @CacheEvict(value = "account", key = "#id")
    public void deleteAccount(Integer id) {
        // 删除数据库中的数据
        accountRepository.deleteById(id);
    }

}
