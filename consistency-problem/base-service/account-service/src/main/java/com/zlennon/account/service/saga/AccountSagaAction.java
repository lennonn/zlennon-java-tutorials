package com.zlennon.account.service.saga;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

public interface AccountSagaAction {


    /**
     * commit 提交
     * @param businessActionContext
     * @return
     */
    boolean withdrawl(Long accountId, int amount) throws Exception;

    /**
     * cancel 撤销
     * @param businessActionContext
     * @return
     */
    boolean compensateAccount(Long accountId, int amount) throws Exception;
}
