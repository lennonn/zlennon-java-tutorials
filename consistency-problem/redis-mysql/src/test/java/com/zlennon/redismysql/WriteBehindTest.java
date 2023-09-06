package com.zlennon.redismysql;

import com.zlennon.redismysql.entity.Account;
import com.zlennon.redismysql.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class WriteBehindTest {

    @Autowired
    private WriteBehind writeBehind;

    @MockBean
    AccountRepository accountRepository;

    private String card="123";
    @Test
    void testUpdateAccountThenGet() throws InterruptedException {
/*        Account account =new Account(card);
        account.credit(300);
        account.setId(2);
        writeBehind.updateAccount(account);*/
       // Account accountById = writeBehind.getAccountById(3);
      //  Assertions.assertEquals(3, accountById.getId().intValue());

        int id =5;
        Account account =new Account(card);
        account.credit(300);
        account.setId(id);
        writeBehind.updateAccount(account);

        Account newAccount = writeBehind.getAccountById(id);
        verify(accountRepository,times(0)).findById(id);
    }


}
