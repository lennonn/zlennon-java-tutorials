/*
package com.zlennon.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"com.zlennon"})
//@PropertySource(value = {"classpath:jdbc.properties"})
public class HibernateConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    // 配置sessionFactory
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(@Autowired DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        // 扫描带有注解的实体类的包
        sessionFactoryBean.setPackagesToScan("com.hy.java.spring.database.hibernate.anno.entity");
        try {
            sessionFactoryBean.afterPropertiesSet();// 一定要加这句话，通过查看源码得知：调用afterPropertiesSet()方法：//在这里开始生成一个真正的SessionFactory对象；然后利用getObjecy生成出来
            // 如果没有这个方法就不能产生sessionFactory对象，就不能通过getObject()方法获得新创建的对象sessionFactory
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactoryBean.getObject();
    }

    // 配置事务
    @Bean(name = "txManager")
    public HibernateTransactionManager getTransactionManager(@Autowired DataSource dataSource, @Autowired SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    // 配置hibernateTemplate
    */
/*
     * @Bean(name = "hibernateTemplate") public HibernateTemplate
     * getHibernateTemplate() { HibernateTemplate hibernateTemplate = new
     * HibernateTemplate(getSessionFactory()); return hibernateTemplate; }
     *//*

}

*/
