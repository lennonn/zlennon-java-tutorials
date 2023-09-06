package com.zlennon.zookeeper.function;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperNamespace {
    @Autowired
    CuratorFramework curatorFramework;
    public String test(){
        return curatorFramework.getNamespace();
    }
}
