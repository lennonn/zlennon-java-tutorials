package com.zlennon.pkceclient.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Oauth2ClientSecurityConfig {

    @Bean
    public SecurityFilterChain pkceFilterChain(HttpSecurity http, OAuth2AuthorizationRequestResolver resolver) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated()
                )
                .oauth2Login(withDefaults())
                .oauth2Client(withDefaults());
        return http.build();
    }

/*    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        // 配置OAuth2客户端的注册信息
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }*/
   @Bean
    public OAuth2AuthorizationRequestResolver pkceResolver(ClientRegistrationRepository clientRegistrationRepository) {
        DefaultOAuth2AuthorizationRequestResolver resolver
                = new DefaultOAuth2AuthorizationRequestResolver(clientRegistrationRepository,"http://localhost:8500");
        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
        return resolver;
    }


    private ClientRegistration clientRegistration() {
        // 配置OAuth2客户端的注册信息
        return ClientRegistration
                .withRegistrationId("pkce")
                .clientId("pkce-client")
                .clientSecret("secret")
                .issuerUri("http://localhost:8500")
                .scope("scope","profile","email")
                // 其他配置参数
                .build();
    }
}
