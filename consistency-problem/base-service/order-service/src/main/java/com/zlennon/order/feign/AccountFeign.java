package com.zlennon.order.feign;


import com.zlennon.account.domain.Account;
import com.zlennon.order.config.SeataInterceptor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value="account-service",path = "/accounts",configuration = {FeignErrorDecoder.class, SeataInterceptor.class})
@Component
public interface AccountFeign {

    @PutMapping("/{id}/withdrawl/{amount}")
    public Account withdrawl(@RequestHeader(value = "X-Txn-ID") String transactionId,@PathVariable(value = "id") Long accountId, @PathVariable(value = "amount") int amount) ;


    @PutMapping("/seata/{id}/reduceAccount/{amount}")
    public boolean reduceAccount(@PathVariable("id") Long accountId, @PathVariable("amount") int amount) throws Exception;

    @PutMapping("/seata/{id}/compensateAccount/{amount}")
    public boolean compensateAccount( @PathVariable("id") Long accountId, @PathVariable("amount") int amount) throws Exception;

}
