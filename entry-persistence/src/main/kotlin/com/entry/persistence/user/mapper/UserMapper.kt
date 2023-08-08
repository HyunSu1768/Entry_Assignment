package com.entry.persistence.user.mapper

import com.entry.auth.model.User
import com.entry.persistence.user.entity.UserJpaEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toDomain(user: User): UserJpaEntity{
        return UserJpaEntity(
            email = user.email,
            nickname = user.nickname
        )
    }
}