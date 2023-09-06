package com.zlennon.zookeeper.controller;

import com.zlennon.zookeeper.function.DistributedLockByZookeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributeLockController {
    /**
     * The Distributed lock by zookeeper.
     */
    @Autowired
    DistributedLockByZookeeper distributedLockByZookeeper;
    private final static String PATH = "testv3";

    /**
     * Gets lock 1.
     *
     * @return the lock 1
     */
    @GetMapping("/lock1")
    public ResponseEntity getLock1() {
        Boolean flag = false;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return  new ResponseEntity("释放锁资源成功", HttpStatusCode.valueOf(200));
        }
        return  new ResponseEntity( "释放锁资源失败",HttpStatusCode.valueOf(500));
    }

    /**
     * Gets lock 2.
     *
     * @return the lock 2
     */
    @GetMapping("/lock2")
    public ResponseEntity getLock2() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return  new ResponseEntity("释放锁资源成功", HttpStatusCode.valueOf(200));
        }
        return  new ResponseEntity( "释放锁资源失败",HttpStatusCode.valueOf(500));
    }

}
