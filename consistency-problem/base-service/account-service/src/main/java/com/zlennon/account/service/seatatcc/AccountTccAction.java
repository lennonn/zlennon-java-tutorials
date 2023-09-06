package com.zlennon.account.service.seatatcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.context.annotation.Profile;

@LocalTCC
@Profile("seata-tcc")
public interface AccountTccAction {

    /**
     * try 尝试
     *
     * BusinessActionContext 上下文对象，用来在两个阶段之间传递数据
     * BusinessActionContextParameter 注解的参数数据会被存入 BusinessActionContext
     * TwoPhaseBusinessAction 注解中commitMethod、rollbackMethod 属性有默认值，可以不写
     *
     * @param businessActionContext
     * @param accountId
     * @param amount
     * @return
     */
    @TwoPhaseBusinessAction(name = "accountTccAction",useTCCFence = true)
    boolean prepareDecreaseMoney(BusinessActionContext businessActionContext,
                                 @BusinessActionContextParameter(paramName = "accountId")Long accountId,
                                 @BusinessActionContextParameter(paramName = "amount")int amount);

    /**
     * commit 提交
     * @param businessActionContext
     * @return
     */
    boolean commit(BusinessActionContext businessActionContext);

    /**
     * cancel 撤销
     * @param businessActionContext
     * @return
     */
    boolean rollback(BusinessActionContext businessActionContext);
}
