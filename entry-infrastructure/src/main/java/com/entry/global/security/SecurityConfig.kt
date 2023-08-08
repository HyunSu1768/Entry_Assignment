package com.entry.global.security

import com.entry.auth.service.OAuthUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val oAuthUserService: OAuthUserService,
) {

    @Bean
    protected fun configure(httpSecurity: HttpSecurity): SecurityFilterChain{
        return httpSecurity
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .oauth2Login()
            .loginPage("/login")
            .defaultSuccessUrl("/success")
            .userInfoEndpoint().userService(oAuthUserService)
            .and()
            .and()
            .build()
    }

}