
package com.zlennon.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ID生成器(雪花算法)
 * @author
 *
 */
@Component
public class IdWorker implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static String nextStringId() {
        return applicationContext.getBean(IdWorderComponent.class).nextStringId();
    }

    public static long nextLongId() {
        return applicationContext.getBean(IdWorderComponent.class).nextLongId();
    }

}
