package com.zlennon.service.saga;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;


public interface ProductSagaAction {




    boolean reduceProduct(Long productId, int quantity);

    /**
     * cancel 补偿
     * @param
     * @return
     */
    boolean compensateProduct(Long productId,int quantity);
}
