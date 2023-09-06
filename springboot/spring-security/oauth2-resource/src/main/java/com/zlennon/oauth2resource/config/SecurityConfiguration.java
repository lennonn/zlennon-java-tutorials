/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zlennon.oauth2resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.client.RestTemplate;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Basic security resource server.
 *
 * @since 5.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {


		http
				//.securityMatcher("/messages/**")
				//.securityMatcher("/userinfo/**")
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers(HttpMethod.GET,"/messages/**").hasAuthority("SCOPE_message.read")
						.requestMatchers(HttpMethod.GET,"/userinfo/**").hasAuthority("SCOPE_openid")
						.anyRequest().authenticated()
				).oauth2ResourceServer((oauth2ResourceServer) ->
						oauth2ResourceServer
								.jwt(withDefaults()));

		return http.build();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
