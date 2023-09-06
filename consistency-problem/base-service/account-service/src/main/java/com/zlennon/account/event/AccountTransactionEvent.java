package com.zlennon.account.event;

import com.zlennon.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountTransactionEvent {

    private String transactionId;

    private Account account;

}
