package com.zlennon.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Slf4j
@Component
public class GlobalI18nFilter implements GlobalFilter, Ordered {
    @Autowired
    private MessageSource messageSource;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

/*        ServerHttpRequest request = exchange.getRequest();
        String language = request.getHeaders().getFirst("content-language");
        Locale locale = Locale.getDefault();
        if (language != null && language.length() > 0) {

            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        LocaleContextHolder.setLocaleContext(new SimpleLocaleContext(locale), true);
        String code = request.getQueryParams().getFirst("code");
        ServerHttpResponse response = exchange.getResponse();
        String message = messageSource.getMessage(code, new Object[]{
        }, LocaleContextHolder.getLocale());*/
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {

        return -100;
    }

}
