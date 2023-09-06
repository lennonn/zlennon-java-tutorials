package com.zlennon.springframwork.core.init;

import com.zlennon.springframwork.Car;
import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
@ToString
public class BeanInitOrder implements InitializingBean, BeanPostProcessor, BeanFactoryAware {

    private String name;
    private String  id;

    @PostConstruct
    public void init(){
        id="init";
        System.out.println("init==>>"+ System.currentTimeMillis());

    }


    @Bean(initMethod = "initCar")
    public Car initCar() {
        return new Car();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        name="afterPropertiesSet";
        System.out.println("afterPropertiesSet==>>"+System.currentTimeMillis());

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization==>>"+ System.currentTimeMillis()+"beanName==>>"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization==>>"+ System.currentTimeMillis()+"beanName==>>"+beanName);
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory==>>"+ System.currentTimeMillis());
    }
}
