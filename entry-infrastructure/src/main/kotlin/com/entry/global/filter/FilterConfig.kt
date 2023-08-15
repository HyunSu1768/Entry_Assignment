package com.entry.global.filter

import com.entry.global.security.principle.CustomUserDetailService
import com.entry.global.security.token.JwtAdapter
import com.entry.global.security.token.JwtResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val customUserDetailService: CustomUserDetailService,
    private val jwtResolver: JwtResolver,
    private val objectMapper: ObjectMapper,
    private val jwtAdapter: JwtAdapter
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {

        val jwtFilter: JwtFilter = JwtFilter(customUserDetailService, jwtResolver, jwtAdapter)
        val globalExceptionFilter: GlobalExceptionFilter = GlobalExceptionFilter(objectMapper)
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(globalExceptionFilter, JwtFilter::class.java)
    }
}