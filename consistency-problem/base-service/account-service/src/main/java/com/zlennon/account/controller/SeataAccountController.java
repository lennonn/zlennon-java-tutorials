package com.zlennon.account.controller;

import com.zlennon.account.domain.Account;
import com.zlennon.account.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * Exposes REST API Interface for interacting with AccountService.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@RestController
@RequestMapping("/accounts/seata")
@Tag(name = "Accounts")
@Profile("seata-saga")
public class SeataAccountController {

    @Autowired
    private SeataSagaAccountService accountService;

    @PutMapping("/{id}/reduceAccount/{amount}")
    public boolean reduceAccount(@PathVariable("id") Long accountId, @PathVariable("amount") int amount) throws Exception {
        return accountService.reduceAccount(accountId, amount);
    }

    @PutMapping("/{id}/compensateAccount/{amount}")
    @Operation(summary = "Find product by ID")
    public boolean compensateAccount(@PathVariable("id") Long accountId, @PathVariable("amount") int amount) throws Exception {
        return accountService.compensateAccount(accountId, amount);
    }

}
