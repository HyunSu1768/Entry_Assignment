package com.entry.global.security.oauth.dto

import com.entry.user.model.User


class OAuthAttributes(
    val attributes: MutableMap<String, Any>,
    val nameAttributesKey: String,
    val name: String,
    val email: String,
) {

    companion object {
        fun of(
            socialName: String,
            attributes: MutableMap<String, Any>
        ): OAuthAttributes? {
            return when (socialName) {
                "kakao" -> ofKakao("id", attributes)
                "naver" -> ofNaver("id", attributes)
                else -> null
            }
        }

        fun ofKakao(
            userNameAttributeName: String,
            attributes: MutableMap<String, Any>,
        ): OAuthAttributes {

            val kakaoAccount: MutableMap<String, Any> = attributes.get("kakao_account") as MutableMap<String, Any>
            val kakaoProfile: MutableMap<String, Any> = kakaoAccount.get("profile") as MutableMap<String, Any>

            return OAuthAttributes(
                name = kakaoProfile.get("nickname").toString(),
                email = kakaoAccount.get("email").toString(),
                nameAttributesKey = userNameAttributeName,
                attributes = attributes
            )

        }

        fun ofNaver(
            userNameAttributeName: String,
            attributes: MutableMap<String, Any>,
        ): OAuthAttributes {

            val response: MutableMap<String, Any> = attributes.get("response") as MutableMap<String, Any>

            return OAuthAttributes(
                name = response.get("nickname").toString(),
                email = response.get("email").toString(),
                nameAttributesKey = userNameAttributeName,
                attributes = response
            )

        }
    }

    fun toEntity(): User {
        return User(
            email = email,
            nickname = name
        )
    }
}