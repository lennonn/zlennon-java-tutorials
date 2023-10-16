package com.zlennon.scheduling.quartz;

import com.zlennon.scheduling.quartz.covid.CovidService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CovidDaliyDataJob extends QuartzJobBean {

    @Autowired
    CovidService covidService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        covidService.saveDailyData();
    }
}
