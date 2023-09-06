package com.zlennon.springframwork.core.factorybean;

import com.zlennon.springframwork.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Car car = new Car();
        car.setColor("白色");
        car.setName("宝马");
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
