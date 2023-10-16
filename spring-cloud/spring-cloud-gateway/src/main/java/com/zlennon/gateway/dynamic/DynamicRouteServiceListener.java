
package com.zlennon.gateway.dynamic;

import cn.hutool.core.text.CharSequenceUtil;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.fastjson2.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 */
@Order
@Component
@Slf4j
@RefreshScope
public class DynamicRouteServiceListener {

    @Autowired
    private DynamicRouteService dynamicRouteService;


    /**
     * 监听Nacos下发的动态路由配置
     */
    @PostConstruct
    public void init() {
        try {
            log.info("开始进行网关路由配置初始化");
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, " 101.43.146.222:8848");
            properties.put(PropertyKeyConst.NAMESPACE, "nacos-routes");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String dataId = "gateway-nacos-routes.json";
            String group = "nacos-routes";
            log.info("网关路由配置初始化，dataId：{}，group：{}", dataId, group);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    nachosListener(configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
            String configInfo = configService.getConfig(dataId, group, 5000);
            if (CharSequenceUtil.isNotBlank(configInfo)) {
                log.info("接收到网关路由初始化配置：\r\n{}", configInfo);
                List<RouteDefinition> routeDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
                dynamicRouteService.addList(routeDefinitions);
                log.info("网关路由配置初始化完成");
            }
        } catch (NacosException nacosException) {
            log.error("网关动态路由初始化异常!", nacosException);
        }
    }

    private void nachosListener(String configInfo) {
        if (CharSequenceUtil.isNotBlank(configInfo)) {
            try {
                log.info("接收到网关路由更新配置：\r\n{}", configInfo);
                List<RouteDefinition> routeDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
                dynamicRouteService.updateList(routeDefinitions);
            } catch (Exception e) {
                log.error("解析路由配置出错", e);
            }
        } else {
            log.warn("当前网关无动态路由相关配置");
        }
    }


}
