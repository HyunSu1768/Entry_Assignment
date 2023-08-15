package com.entry.persistence.user.mapper

import com.entry.user.model.User
import com.entry.persistence.user.entity.UserJpaEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toEntity(user: User): UserJpaEntity{

        return UserJpaEntity(
            id = user.uuid,
            email = user.email,
            nickname = user.nickname
        )
    }

    fun toDomain(userJpaEntity: UserJpaEntity): User {

        return User(
            uuid = userJpaEntity.id!!,
            email = userJpaEntity.email,
            nickname = userJpaEntity.nickname
        )
    }
}