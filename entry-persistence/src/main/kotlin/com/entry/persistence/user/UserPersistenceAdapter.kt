package com.entry.persistence.user

import com.entry.auth.port.out.FindUserPort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.persistence.user.repository.UserRepository
import com.entry.user.model.User
import com.entry.user.port.out.LoadCurrentUserPort
import org.springframework.security.core.context.SecurityContextHolder

@PersistenceAdapter
class UserPersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper
): FindUserPort, LoadCurrentUserPort {
    override fun findUserByEmail(email: String?): User {

        val user = userRepository.findByEmail(email)
            .orElseThrow()

        return userMapper.toEntity(user)

    }

    override fun load(): User {
        val userEmail = SecurityContextHolder.getContext().authentication.name
        val userJpaEntity = userRepository.findByEmail(userEmail)
            .orElseThrow()
        return userMapper.toEntity(userJpaEntity)
    }

}