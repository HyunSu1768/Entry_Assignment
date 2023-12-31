package com.entry.global.security.token

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtResolver(
    val jwtProperties: JwtProperties
) {

    fun resolveToken(request: HttpServletRequest): String?{

        val bearerToken = request.getHeader(jwtProperties.header)
        if(bearerToken.startsWith(jwtProperties.prefix) && bearerToken.length > jwtProperties.prefix.length+1 && bearerToken != null){
            return bearerToken.substring(7)
        }
        return null
    }
}