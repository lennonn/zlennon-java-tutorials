package com.zlennon.account.service;

import com.zlennon.account.domain.Account;

public interface IAccountService {

    default Account createAccount(Account account) {
        return null;
    }

    default Account findByCustomerId(Long customerId) {
        return null;
    }

    default void deposit(Long accountId, int amount, String transactionId) {
    }

    default void withdrawl(Long accountId, int amount, String transactionId) {

    }

    default void transfer(Long accountId, int amount, String transactionId) {

    }

    default Account findByAccountId(Long accountId) {
        return null;
    }
}
