package com.zlennon.gateway.config;

import com.zlennon.gateway.filter.EncryptDecryptFilter;
import com.zlennon.gateway.filter.WhitelistFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class RouteLocatorConfig {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private WhitelistFilter whitelistFilter;
    @Autowired
    private EncryptDecryptFilter encryptDecryptFilter;
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/test/*")
                        .uri("https://www.zlennon.com"))
                .route("chatgpt", r -> r.path("/**")
                        .filters(f -> f.tokenRelay())
                        .uri("lb://chatgpt-model-service")
                )

                .route("demoi18n", r -> r.path("/demoi18n/**")
                        //.uri("lb://chatgpt-model-service"))
                        .uri("http://127.0.0.1:7888"))
                .route("whitelist_route", r -> r
                        .path("/whitelist")
                        .filters(f -> f.filter(whitelistFilter))
                        .uri("http://whitelist.com"))
                .build();
    }

/*    @Bean
    public RouterFunction<ServerResponse> personRoutes() {
        return RouterFunctions.route()
                .GET("/demoi18n/demo", RequestPredicates.accept(MediaType.APPLICATION_JSON), (serverRequest)->{
                    Mono<String> code = Mono.just(messageSource.getMessage(serverRequest.queryParams().getFirst("code"), new Object[]{
                    }, LocaleContextHolder.getLocale()));
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(code,String.class);
                })
                .build();
    }*/
}
