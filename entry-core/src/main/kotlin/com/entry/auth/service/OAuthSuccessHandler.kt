package com.entry.auth.service

import com.entry.auth.dto.response.TokenResponse
import com.entry.auth.port.out.GenerateJwtPort
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuthSuccessHandler(
    private val generateJwtPort: GenerateJwtPort,
    private val objectMapper: ObjectMapper
): SimpleUrlAuthenticationSuccessHandler() {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {

        val user = authentication?.principal as OAuth2User
        writeTokenResponse(response, generateJwtPort.generateToken(user.attributes["email"].toString()))

    }

    private fun writeTokenResponse(response: HttpServletResponse?, tokenResponse: TokenResponse){
        response?.addHeader("accessToken", tokenResponse.accessToken)
        response!!.contentType = "application/json;charset=UTF-8"
    }
}