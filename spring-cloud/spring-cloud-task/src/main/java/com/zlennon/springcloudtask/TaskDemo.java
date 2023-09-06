package com.zlennon.springcloudtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.logging.Logger;

//@EnableTask
public class TaskDemo {

    private final static Logger LOGGER = Logger.getLogger(TaskDemo.class.getName());

    @Autowired
    private DataSource dataSource;

    @Bean
    public HelloWorldTaskConfigurer getTaskConfigurer()
    {
        return new HelloWorldTaskConfigurer(dataSource);
    }

    @Bean
    public TaskListener taskListener() {
        return new TaskListener();
    }
}
