package com.entry.global.security.oauth

import com.entry.global.security.oauth.dto.OAuthAttributes
import com.entry.user.model.User
import com.entry.user.port.out.UserSaveOrUpdatePort
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
class OAuthUserService(
    val saveOrUpdatePort: UserSaveOrUpdatePort
): OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {

        val service: OAuth2UserService<OAuth2UserRequest, OAuth2User> = DefaultOAuth2UserService()
        val oAuth2User = service.loadUser(userRequest)

        val originAttributes: MutableMap<String, Any> = oAuth2User.attributes

        val registrationId = userRequest!!.clientRegistration.registrationId

        val attributes: OAuthAttributes? = OAuthAttributes.of(registrationId, originAttributes)

        val user = attributes?.let { User(email = it.email, nickname = attributes.name) }

        user?.let { saveOrUpdatePort.saveOrUpdate(it) }

        return DefaultOAuth2User(
            setOf(SimpleGrantedAuthority("ROLE_TEST")),
            attributes?.attributes,
            attributes?.nameAttributesKey
        )
    }
}