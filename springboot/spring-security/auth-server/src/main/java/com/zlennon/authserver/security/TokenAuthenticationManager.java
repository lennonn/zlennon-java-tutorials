package com.zlennon.authserver.security;

import com.zlennon.authserver.common.JwtTokenUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**

* @description token 认证处理
*/
//@Component
//@Primary
public class TokenAuthenticationManager implements ReactiveAuthenticationManager {

@Override
@SuppressWarnings("unchecked")
public Mono<Authentication> authenticate(Authentication authentication) {
    return Mono.just(authentication)
            .map(auth -> JwtTokenUtil.parseJwtRsa256(auth.getPrincipal().toString()))
            .map(claims -> {
                Collection<? extends GrantedAuthority> roles = (Collection<? extends GrantedAuthority>) claims.get("roles");
                return new UsernamePasswordAuthenticationToken(
                        claims.getSubject(),
                        null,
                        roles);
            });
}
}
