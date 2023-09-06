package com.zlennon.account.service.seatatcc;

import com.zlennon.account.domain.Account;
import com.zlennon.account.repository.AccountRepository;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Profile("seata-tcc")
@Slf4j
public class AccountTccActionImpl implements AccountTccAction{

    @Autowired
    private AccountRepository accountRepository;

    /**
     * try 尝试
     *
     * @param businessActionContext
     * @param userId
     * @param money
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareDecreaseMoney(BusinessActionContext businessActionContext, Long userId, int money) {
        log.info("减少账户金额，第一阶段锁定金额，userId=" + userId + "， money=" + money);
        Account account = accountRepository.findById(userId).get();
        //余额不足，处理
        if (account.getBalance().compareTo(money) < 0) {
            throw new RuntimeException("账户金额不足");
        }
        //冻结钱
        accountRepository.updateFrozen(userId, account.getBalance()-money,
                account.getFrozen()==null?money:account.getFrozen()+money);
        return true;
    }

    /**
     * commit 提交
     *
     * @param businessActionContext
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        long userId = Long.parseLong(businessActionContext.getActionContext("userId").toString());
        int money = (int)businessActionContext.getActionContext("money");
        log.info("减少账户金额，第二阶段，提交，userId=" + userId + "， money=" + money);
        accountRepository.updateFrozenToUsed(userId, money);
        return true;
    }

    /**
     * cancel 撤销
     *
     * @param businessActionContext
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean rollback(BusinessActionContext businessActionContext) {
        long userId = Long.parseLong(businessActionContext.getActionContext("userId").toString());
        int money = (int)businessActionContext.getActionContext("money");
        log.info("减少账户金额，第二阶段，回滚，userId=" + userId + "， money=" + money);
        accountRepository.updateFrozenToResidue(userId, money);
        return true;
    }
}
