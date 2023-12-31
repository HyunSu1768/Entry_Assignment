package com.entry.global.security

import com.entry.global.security.oauth.OAuthSuccessHandler
import com.entry.global.security.oauth.OAuthUserService
import com.entry.global.filter.FilterConfig
import com.entry.global.security.principle.CustomUserDetailService
import com.entry.global.security.token.JwtAdapter
import com.entry.global.security.token.JwtResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val oAuthUserService: OAuthUserService,
    private val oAuthSuccessHandler: OAuthSuccessHandler,
    private val jwtAdapter: JwtAdapter,
    private val jwtResolver: JwtResolver,
    private val objectMapper: ObjectMapper,
    private val customUserDetailService: CustomUserDetailService
) {

    @Bean
    protected fun configure(httpSecurity: HttpSecurity): SecurityFilterChain{
        return httpSecurity
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/login/oauth2/*", "/oauth2/authorization/naver", "/oauth2/authorization/kakao","/favicon.ico").permitAll()
            .anyRequest().permitAll()
            .and()
            .oauth2Login()
            .loginPage("/login")
            .defaultSuccessUrl("/success")
            .userInfoEndpoint().userService(oAuthUserService)
            .and()
            .successHandler(oAuthSuccessHandler)
            .and()
            .apply(FilterConfig(customUserDetailService, jwtResolver, objectMapper, jwtAdapter))
            .and()
            .build()
    }
}