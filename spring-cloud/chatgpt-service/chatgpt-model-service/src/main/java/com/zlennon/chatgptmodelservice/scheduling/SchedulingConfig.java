package com.zlennon.chatgptmodelservice.scheduling;

import com.zlennon.chatgptmodelservice.service.ChatModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.zlennon")
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

    @Autowired
    private ChatModelService chatModelService;

    @Value("${executeCorn:0 0 1 * * ?}")
    private String executeCorn;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
        //return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                () -> chatModelService.execute(),
                (TriggerContext triggerContext) -> new CronTrigger(executeCorn).nextExecutionTime(triggerContext).toInstant()
        );
    }

}
