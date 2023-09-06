package com.zlennon.gateway.filter;


import lombok.Data;
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
//@RefreshScope
public class GlobalRequestDecryptFilter implements GlobalFilter, Ordered {


	private final AntPathMatcher antPathMatcher = new AntPathMatcher();
	private static final String partition = "_";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
				return chain.filter(exchange.mutate().request(request).build());
	}

	@Override
	public int getOrder() {//多语言之前执行
		return -98;
	}

	@Data
	static class BodyData {
		private String data;
	}
}
