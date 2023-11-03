package com.zlennon.springframwork.core.init;

import com.zlennon.springframwork.Car;
import com.zlennon.springframwork.core.factorybean.MyFactoryBean;
import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
@ToString
public class BeanInitOrder implements InitializingBean, BeanPostProcessor, BeanFactoryAware , ApplicationContextAware {

    private String name;
    private String  id;
    private ApplicationContext applicationContext;

    public BeanInitOrder() {
        this.name = "constructor";
        System.out.println("constructor==>>"+ this.name);
    }

    private

    @PostConstruct
    void init(){
        name="PostConstruct";
        id="init";
        System.out.println("init==>>"+ this.name);

    }


/*    @Bean(initMethod = "initCar")
    public Car initCar() {
        return new Car();
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        name="afterPropertiesSet";
        System.out.println("afterPropertiesSet==>>"+System.currentTimeMillis()+"Car.name=>"+this.name);

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

            this.name="postProcessBeforeInitialization";
            System.out.println("postProcessBeforeInitialization==>>" + System.currentTimeMillis() + "beanName==>> " + beanName);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
           // this.name="postProcessAfterInitialization";
           // System.out.println("postProcessAfterInitialization==>>" + System.currentTimeMillis() + "beanName==>> " + this.name);
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory==>>"+ System.currentTimeMillis());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
