package com.zlennon.extend;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public abstract class AbstractInfo {
    boolean flag =false;
    static ScheduledThreadPoolExecutor executorService = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ScheduledThreadPoolExecutor getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ScheduledThreadPoolExecutor executorService) {
        this.executorService = executorService;
    }
}
