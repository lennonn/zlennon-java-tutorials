package com.zlennon.chatgptmodelservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Profile("rabbit")
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    @Profile("rabbit")
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .securityMatcher("/chatgpt/**")
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/chatgpt/**").hasAuthority("SCOPE_profile")
                        .requestMatchers(HttpMethod.GET,"/test/**").permitAll()
                        .anyRequest().authenticated()
                ).oauth2ResourceServer((oauth2ResourceServer) ->
                        oauth2ResourceServer
                                .jwt(withDefaults()));

        return http.build();
    }
}
