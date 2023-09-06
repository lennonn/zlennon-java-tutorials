package com.zlennon.zookeeper;

import com.zlennon.zookeeper.CalculateTask;
import com.zlennon.zookeeper.function.ConfigServer;
import com.zlennon.zookeeper.function.DistributedLockByZookeeper;
import com.zlennon.zookeeper.function.ZookeeperNamespace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
public class FunctionTest {

    @Autowired
    DistributedLockByZookeeper lock;


    @Autowired
    ConfigServer configServer;


    @Autowired
    ZookeeperNamespace zkNamespace;

    @Test
    public void testAcquireLock() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            lock.acquireDistributedLock("compute");
            Future<Integer> submit = executorService.submit(new CalculateTask());
            System.out.println(submit.get());
            lock.releaseDistributedLock("compute");
        }
    }

    @Test
    public void testConfigServer(){
        // 模拟一个配置项，实际生产中会在系统初始化时从配置文件中加载进来
        configServer.save("timeout", "1000");

        // 每3S打印一次获取到的配置项
        for (int i = 0; i < 10; i++) {
            System.out.println(configServer.get("timeout"));
            if(i==7){
                configServer.save("timeout", "20000");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testNamespace(){
        System.out.println(zkNamespace.test());
    }
}
