package com.zlennon.account.service.saga;

import com.zlennon.account.domain.Account;
import com.zlennon.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("accountSagaAction")
@Slf4j
public class AccountSagaActionImpl implements AccountSagaAction{

    @Autowired
    AccountRepository accountRepository;


    @Transactional(rollbackFor = Exception.class)
    /**
     * commit 扣钱
     * @return
     */
    public boolean withdrawl(Long accountId, int amount) throws Exception {
        log.info("Account saga withdrawl accountId=" + accountId + "， amount=" + amount);
        Account account = accountRepository.findById(accountId).get();
        //余额不足，处理
        if (account.getBalance().compareTo(amount) < 0) {
           // return false;
            throw new Exception("账户金额不足");
        }
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
        return  true;
    }

    /**
     * cancel 撤销
     * @return
     */
    public boolean compensateAccount(Long accountId, int amount){
        log.info("Account saga compensateWithdrawl accountId=" + accountId + "， amount=" + amount);
        Account account = accountRepository.findById(accountId).get();
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return  true;
    }
}
