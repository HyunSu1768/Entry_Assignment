package com.entry.global.filter

import com.entry.global.security.principle.CustomUserDetailService
import com.entry.global.security.token.JwtAdapter
import com.entry.global.security.token.JwtResolver
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val customUserDetailService: CustomUserDetailService,
    private val jwtResolver: JwtResolver,
    private val jwtAdapter: JwtAdapter
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val resolveToken: String? = jwtResolver.resolveToken(request)

        if(resolveToken != null){
            val accountId = jwtAdapter.getSubjectWithExpiredCheck(resolveToken)
            val userDetails: UserDetails = customUserDetailService.loadUserByUsername(accountId)
            val authentication: Authentication =
                UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}