package com.entry.global.security.oauth

import com.entry.auth.dto.response.TokenResponse
import com.entry.auth.port.out.GenerateJwtPort
import com.entry.global.security.oauth.dto.OAuthAttributes
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class OAuthSuccessHandler(
    private val generateJwtPort: GenerateJwtPort,
): SimpleUrlAuthenticationSuccessHandler() {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {

        val oauth2Authentication = authentication as OAuth2AuthenticationToken
        val user = authentication.principal as OAuth2User

        val social = oauth2Authentication.authorizedClientRegistrationId

        when (social) {
            "naver" -> writeTokenResponse(response, generateJwtPort.generateToken(user.attributes["email"].toString()))
            "kakao" -> {
                val attributes = OAuthAttributes.of(social, user.attributes)
                writeTokenResponse(response, generateJwtPort.generateToken(attributes!!.email))
                }
            }
        }


    private fun writeTokenResponse(response: HttpServletResponse?, tokenResponse: TokenResponse){

        response?.addHeader("accessToken", tokenResponse.accessToken)
        response!!.contentType = "application/json;charset=UTF-8"
    }
}