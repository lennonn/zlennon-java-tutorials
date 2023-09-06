package com.zlennon.gateway.filter;

import com.zlennon.gateway.config.IPListConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class BlacklistFilter implements GlobalFilter, Ordered {

    @Autowired
    IPListConfig ipListConfig;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String ipAddress = request.getRemoteAddress().getAddress().getHostAddress();

        if (ipListConfig.getBlackList().contains(ipAddress)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Set the order to a value greater than the default order of NettyRoutingFilter
        // to make sure this filter is executed before the default filters.
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

