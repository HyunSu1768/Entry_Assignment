package com.entry.global.security.token

import com.entry.auth.dto.response.TokenResponse
import com.entry.auth.port.out.GenerateJwtPort
import org.springframework.stereotype.Component
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date

@Component
class JwtAdapter: GenerateJwtPort {

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
            .setExpiration(Date(now.getTime() + 36000L))
            .signWith(SignatureAlgorithm.HS256, "ajsdklfajskdlasdjfklajsdlkfajsdklffajsdlfajsdlfjaksldfjalsdfjalsdfjkl")
            .compact()
    }
}