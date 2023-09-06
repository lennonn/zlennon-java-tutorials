package com.zlennon.account.service;

import com.zlennon.account.devil.AccountNotFoundException;
import com.zlennon.account.domain.Account;
import com.zlennon.account.repository.AccountRepository;
import com.zlennon.account.service.saga.AccountSagaAction;
import com.zlennon.account.service.seatatcc.AccountTccAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("seata-saga")
@Slf4j
public class SeataSagaAccountService implements IAccountService{



    @Autowired
    AccountSagaAction accountSagaAction;



    public boolean compensateAccount(Long accountId, int amount) throws Exception {
       return accountSagaAction.compensateAccount(accountId,amount);
    }


    public boolean reduceAccount(Long accountId, int amount) throws Exception {
        return accountSagaAction.withdrawl(accountId,amount);
    }
}
