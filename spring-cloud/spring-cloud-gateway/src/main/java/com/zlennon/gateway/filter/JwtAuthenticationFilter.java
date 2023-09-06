package com.zlennon.gateway.filter;

import com.zlennon.gateway.common.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Predicate;
@Component
public class JwtAuthenticationFilter implements AuthenticationFilter{

        @Autowired
        private JwtTokenUtil jwtUtil;
        
        @Autowired
        RestTemplate restTemplate;

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();

/*            final List<String> apiEndpoints = List.of("/register", "/login");

            Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
                    .noneMatch(uri -> r.getURI().getPath().contains(uri));

            if (isApiSecured.test(request)) {
                if (!request.getHeaders().containsKey("Authorization")) {
                    ServerHttpResponse response = exchange.getResponse();
                    //response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    //跳转到认证服务
                    String authServer="http://localhost:8200/login?redirect_uri=http://localhost:7999"+request.getPath();
                    response.getHeaders().set(HttpHeaders.LOCATION, authServer);
                    response.setStatusCode(HttpStatus.SEE_OTHER);
                    return response.setComplete();
                }

                final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

                try {
                    jwtUtil.validateToken(token);
                } catch (Exception e) {
                    // e.printStackTrace();

                    ServerHttpResponse response = exchange.getResponse();
                    response.setStatusCode(HttpStatus.BAD_REQUEST);

                    return response.setComplete();
                }

                Claims claims = jwtUtil.parseJwtRsa256(token);
                exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
            }*/

            return chain.filter(exchange);

    }


    @Override
    public int getOrder() {
        return -1000;
    }
}
