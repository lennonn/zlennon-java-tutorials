package com.zlennon.account.service;

import com.zlennon.account.devil.AccountNotFoundException;
import com.zlennon.account.domain.Account;
import com.zlennon.account.repository.AccountRepository;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Profile("seata-xa")
@Slf4j
public class SeataXaAccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).orElseThrow(() -> new AccountNotFoundException("Account not exists for customer ID: " + customerId));
    }

    @Async
    @Transactional
    public void deposit(Long accountId, int amount, String transactionId) {
        log.info("SeataXaAccountService xid = " + RootContext.getXID());

        transfer(accountId, amount, transactionId);
    }

    @Async
    @Transactional
    public void withdrawl(Long accountId, int amount, String transactionId) {
        log.info("SeataXaAccountService xid = " + RootContext.getXID());
        transfer(accountId, amount * (-1), transactionId);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    public void transfer(Long accountId, int amount, String transactionId) {
        log.info("Transferring money to account={}, amount={}, xid: {}", accountId, amount, RootContext.getXID());
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if(accountOpt.get().getBalance()<amount){
            throw new RuntimeException("余额不足");
        }
        accountOpt.ifPresent(account -> {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        });
    }
}
