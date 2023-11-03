package com.zlennon.springframwork;

import com.zlennon.springframwork.core.init.BeanInitOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFramworkApplication  implements CommandLineRunner {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringFramworkApplication.class, args);
/*		Car myFactoryBean = applicationContext.getBean("myFactoryBean", Car.class);
		Car car = applicationContext.getBean("car", Car.class);
		System.out.println(myFactoryBean.toString());
		System.out.println(car.toString());*/
		BeanInitOrder beanInitOrder = applicationContext.getBean("beanInitOrder", BeanInitOrder.class);
		System.out.println(beanInitOrder.toString());
		//Car car = applicationContext.getBean("initCar", Car.class);
		//System.out.println(car.toString());

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
