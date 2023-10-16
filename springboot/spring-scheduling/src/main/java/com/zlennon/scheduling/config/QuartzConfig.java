package com.zlennon.scheduling.config;

import com.zlennon.scheduling.quartz.CovidDaliyDataJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(CovidDaliyDataJob.class)
                .storeDurably()
                .withIdentity("Covid_Daily_Data_Job_Detail")
                .withDescription("获取每日的各个国家新冠病毒统计数据JobDetail")
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("Covid_Daily_Data_Quartz_Trigger")
                .withDescription("获取每日的各个国家新冠病毒统计数据触发器")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                .build();
    }
}
