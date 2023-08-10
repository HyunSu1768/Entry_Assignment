package com.entry.persistence.user

import com.entry.user.port.out.FindUserPort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.persistence.user.repository.UserRepository
import com.entry.user.model.User

@PersistenceAdapter
class UserPersistenceAdapter(
    val userRepository: UserRepository,
    val userMapper: UserMapper
): FindUserPort {

    override fun findUserByEmail(email: String?): User {

        val user = userRepository.findByEmail(email)

        return userMapper.toEntity(user)
    }

}