package com.ani.worker.interceptor;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class ReqInterceptor {

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return template -> {
            JwtAuthenticationToken jwt = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            template.header("Authorization", "Bearer "+ jwt.getToken().getTokenValue());
        };
    }
}
