package com.zlennon.account.controller;

import com.zlennon.account.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlennon.account.domain.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * Exposes REST API Interface for interacting with AccountService.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private EventBus eventBus;

    @PostMapping
    @Operation(summary = "Create a new account")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get account by customer ID")
    public Account findByCustomerId(@PathVariable("customerId") Long customerId) {
        return accountService.findByCustomerId(customerId);
    }

    @PutMapping("/{id}/deposit/{amount}")
    @Operation(summary = "Deposit money in customer account")
    public Account deposit(@PathVariable("id") Long accountId, @PathVariable("amount") int amount, @RequestHeader(value = "X-Txn-ID",required = false) String transactionId) {
        if(accountService instanceof SeataATAccountService
                ||accountService instanceof SeataTCCAccountService
                ||accountService instanceof SeataXaAccountService
        ){
            accountService.deposit(accountId, amount, transactionId);
            return accountService.findByAccountId(accountId);
        }
        accountService.deposit(accountId, amount, transactionId);
        return eventBus.receiveEvent(transactionId).getAccount();
    }

    @PutMapping("/{id}/withdrawl/{amount}")
    @Operation(summary = "Withdraw money from customer account")
    public Account withdrawl(@PathVariable("id") Long accountId, @PathVariable("amount") int amount, @RequestHeader(value = "X-Txn-ID",required = false) String transactionId) {
        accountService.withdrawl(accountId, amount, transactionId);
        return accountService.findByAccountId(accountId);
    }

}
