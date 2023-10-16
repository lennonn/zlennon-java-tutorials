package com.zlennon.scheduling.taskscheduler;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;

@TestPropertySource("classpath:application-test.yml")
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTaskSchedulerTest {

    @Autowired
    ThreadPoolTaskSchedulerExamples taskSchedulerExamples;

    @Test
    public void testScheduleRunnable() throws InterruptedException {
        taskSchedulerExamples.scheduleRunnableWithCronTrigger();
        sleep(30000);
    }
}
