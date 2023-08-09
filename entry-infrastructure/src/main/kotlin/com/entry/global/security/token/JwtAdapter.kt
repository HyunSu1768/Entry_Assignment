package com.entry.global.security.token

import com.entry.auth.dto.response.TokenResponse
import com.entry.auth.port.out.GenerateJwtPort
import com.entry.auth.port.out.JwtExpiredCheckPort
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import org.springframework.stereotype.Component
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm
import java.lang.RuntimeException
import java.util.Date

@Component
class JwtAdapter(
    val jwtProperties: JwtProperties
): GenerateJwtPort, JwtExpiredCheckPort {

    override fun generateToken(email: String): TokenResponse {
        return TokenResponse(
            generateAccessToken(email)
        )
    }

    private fun generateAccessToken(email: String): String{
        val now = Date()
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(Date(now.getTime() + jwtProperties.accessExpiredExp * 1000L))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .compact()
    }

    override fun getSubjectWithExpiredCheck(token: String): String {
        val body = getBody(token)

        if(body.expiration.before(Date())){
            throw RuntimeException()
        } else{
            return body.subject
        }
    }

    private fun getBody(token: String): Claims{
        try {
            return Jwts.parser().setSigningKey(jwtProperties.secretKey).parseClaimsJws(token).body
        } catch (e: JwtException){
            throw BusinessException(ErrorCode.INVALID_TOKEN)
        }
    }
}