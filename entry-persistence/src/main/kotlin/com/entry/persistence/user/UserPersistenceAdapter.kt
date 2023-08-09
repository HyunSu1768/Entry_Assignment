package com.entry.persistence.user

import com.entry.auth.model.User
import com.entry.auth.port.out.FindUserPort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.persistence.user.repository.UserRepository

@PersistenceAdapter
class UserPersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper
): FindUserPort {
    override fun findUserByEmail(email: String?): User {

        val user = userRepository.findByEmail(email)
            .orElseThrow()

        return userMapper.toEntity(user)

    }

}