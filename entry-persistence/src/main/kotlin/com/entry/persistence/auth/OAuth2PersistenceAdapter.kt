package com.entry.persistence.auth

import com.entry.user.model.User
import com.entry.auth.port.out.UserSaveOrUpdatePort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.persistence.user.repository.UserRepository

@PersistenceAdapter
class OAuth2PersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper,
): UserSaveOrUpdatePort {

    override fun saveOrUpdate(user: User) {
        val userJpaEntity = userMapper.toDomain(user)
        if(userRepository.existsByEmail(user.email)){
            userRepository.save(
                userMapper.toDomain(
                    user.copy(
                        nickname = user.nickname
                    )
                )
            )
        }
        else{
            userRepository.save(userJpaEntity)
        }
    }

}