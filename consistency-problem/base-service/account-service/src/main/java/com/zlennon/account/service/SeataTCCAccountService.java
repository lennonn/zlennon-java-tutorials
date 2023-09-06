package com.zlennon.account.service;

import com.zlennon.account.devil.AccountNotFoundException;
import com.zlennon.account.domain.Account;
import com.zlennon.account.repository.AccountRepository;
import com.zlennon.account.service.seatatcc.AccountTccAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Profile("seata-tcc")
@Slf4j
public class SeataTCCAccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    AccountTccAction accountTccAction;


    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).orElseThrow(() -> new AccountNotFoundException("Account not exists for customer ID: " + customerId));
    }


    public void deposit(Long accountId, int amount, String transactionId) {
        transfer(accountId, amount, transactionId);
        //accountTccAction.prepareDecreaseMoney(null,accountId,amount);
    }

    public void withdrawl(Long accountId, int amount, String transactionId) {
        //transfer(accountId, amount * (-1), transactionId);
        accountTccAction.prepareDecreaseMoney(null,accountId,amount);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    public void transfer(Long accountId, int amount, String transactionId) {
        log.info("Transferring money to account={}, amount={}, txnId: {}", accountId, amount, transactionId);
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        accountOpt.ifPresent(account -> {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        });
    }
}
