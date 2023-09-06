
package com.zlennon.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/webjars/**", "/assets/**","/oauth2/token/**");
    }

  //  @Bean
    SecurityWebFilterChain configure(ServerHttpSecurity http, ReactiveClientRegistrationRepository clientRegistrationRepository) {
		// @formatter:off
		http
			.authorizeExchange((authorize) -> authorize
				.pathMatchers("/", "/public/**").permitAll()
				.anyExchange().authenticated()
			)
                .oauth2Login(withDefaults())
                .oauth2Client(withDefaults());
		// @formatter:on
		return http.build();
	}

/*    @Bean
    public SecurityFilterChain securityFilterChain(ServerHttpSecurity http,
                                                   ClientRegistrationRepository clientRegistrationRepository) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/logged-out").permitAll()
                                .requestMatchers("/", "/public/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/oauth2/authorization/messaging-client-oidc"))
                .oauth2Client(withDefaults())
                .logout(logout ->
                        logout.logoutSuccessHandler(oidcLogoutSuccessHandler(clientRegistrationRepository)));
        return http.build();
    }*/


    private ServerLogoutSuccessHandler oidcLogoutSuccessHandler(
            ReactiveClientRegistrationRepository clientRegistrationRepository) {

        OidcClientInitiatedServerLogoutSuccessHandler logoutSuccessHandler
                = new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository);

        // Set the location that the End-User's User Agent will be redirected to
        // after the logout has been performed at the Provider
        logoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logged-out");

        return logoutSuccessHandler;
    }

}
