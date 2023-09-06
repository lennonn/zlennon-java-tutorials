package com.zlennon.account.service;

import java.util.Optional;

import com.zlennon.account.devil.AccountNotFoundException;
import com.zlennon.account.event.AccountTransactionEvent;
import com.zlennon.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlennon.account.domain.Account;
import lombok.extern.slf4j.Slf4j;

@Service
@Profile("dev")
@Slf4j
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

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
        transfer(accountId, amount, transactionId);
    }

    @Async
    @Transactional
    public void withdrawl(Long accountId, int amount, String transactionId) {
        transfer(accountId, amount * (-1), transactionId);
    }

    public void transfer(Long accountId, int amount, String transactionId) {
        log.info("Transferring money to account={}, amount={}, txnId: {}", accountId, amount, transactionId);
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        accountOpt.ifPresent(account -> {
            account.setBalance(account.getBalance() + amount);
            eventPublisher.publishEvent(new AccountTransactionEvent(transactionId, account));
            accountRepository.save(account);
        });
    }
}
