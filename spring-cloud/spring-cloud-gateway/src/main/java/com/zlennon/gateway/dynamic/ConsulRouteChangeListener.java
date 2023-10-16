package com.zlennon.gateway.dynamic;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Slf4j
public class ConsulRouteChangeListener  {

    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @Autowired
    DynamicRouteService dynamicRouteService;


    @PostConstruct
    void init(){
        log.info(config);
    }

/*    @Override
    public void onApplicationEvent(RefreshRoutesEvent event) {
        // 在路由配置变化时，重新获取路由规则
        routeDefinitionLocator.getRouteDefinitions().collectList().subscribe(routes -> {
            // 处理新的路由规则，例如打印或其他操作
            for (RouteDefinition route : routes) {
                dynamicRouteService.save(route);
                log.info("路由保存成功{}",route.toString());
            }
        });
    }*/

    //@Value("${springcloud/gateway/dynamic-route}")
    private String config;
}

