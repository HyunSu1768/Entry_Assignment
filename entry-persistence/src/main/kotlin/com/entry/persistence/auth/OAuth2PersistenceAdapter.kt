package com.entry.persistence.auth

import com.entry.auth.model.User
import com.entry.auth.port.out.UserSaveOrUpdatePort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.persistence.user.repository.UserRepository
import org.springframework.stereotype.Component

@PersistenceAdapter
class OAuth2PersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper
): UserSaveOrUpdatePort {

    override fun saveOrUpdate(user: User) {
        val userJpaEntity = userMapper.toDomain(user)
        if(userRepository.existsByEmail(user.email)){
            userJpaEntity.update(user.nickname)
        }
        else{
            userRepository.save(userJpaEntity)
        }
    }

}