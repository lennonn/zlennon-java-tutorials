package com.zlennon.service.tcc;

import com.zlennon.domain.Product;
import com.zlennon.domain.ProductEntity;
import com.zlennon.repository.ProductRepository;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Component
@Profile("seata-tcc")
@Slf4j
public class ProductTccActionImpl implements ProductTccAction{

     @Autowired
    private ProductRepository productRepository;
     /**
     * try 尝试
     *
     * BusinessActionContext 上下文对象，用来在两个阶段之间传递数据
     * BusinessActionContextParameter 注解的参数数据会被存入 BusinessActionContext
     * TwoPhaseBusinessAction 注解中commitMethod、rollbackMethod 属性有默认值，可以不写
     *
     * @param businessActionContext
     * @param productId
     * @param count
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareDecreaseStorage(BusinessActionContext businessActionContext, Long productId, Integer count) {
        log.info("减少商品库存，第一阶段，锁定减少的库存量，productId="+productId+"， count="+count);
        log.info("xid = " + RootContext.getXID());
        Optional<ProductEntity> product = productRepository.findById(productId);
        if (product.get().getQuantity()-count<0) {
            throw new RuntimeException("库存不足");
        }
        /*
        库存减掉count， 冻结库存增加count
         */
        productRepository.updateFrozen(productId, product.get().getQuantity()-count,
                product.get().getFrozen()==null?count:product.get().getFrozen()+count);
        //保存标识
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
        long productId = Long.parseLong(businessActionContext.getActionContext("productId").toString());
        int count = Integer.parseInt(businessActionContext.getActionContext("quantity").toString());
        log.info("减少商品库存，第二阶段提交，productId="+productId+"， quantity="+count);
        productRepository.updateFrozenToUsed(productId, count);
        //删除标识
        return true;
    }

    /**
     * cancel 撤销
     *
     * @param businessActionContext
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        long productId = Long.parseLong(businessActionContext.getActionContext("productId").toString());
        int count = Integer.parseInt(businessActionContext.getActionContext("quantity").toString());
        log.info("减少商品库存，第二阶段，回滚，productId="+productId+"， quantity="+count);
        productRepository.updateFrozenToResidue(productId, count);
        return true;
    }
}
