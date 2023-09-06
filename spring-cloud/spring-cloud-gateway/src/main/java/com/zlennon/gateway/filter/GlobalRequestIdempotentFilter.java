package com.zlennon.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 */
@Component
@Slf4j
public class GlobalRequestIdempotentFilter implements GlobalFilter, Ordered {


	@Resource
	private ObjectMapper objectMapper;


	//token默认常量
	private final String tokenConstant = "token";

	//请求过期时间（单位：秒）

	private final long requestExpirationTime = 5;

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();



	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {//多语言之前执行
		return -900;
	}


}
