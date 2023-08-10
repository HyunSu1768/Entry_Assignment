package com.entry.persistence.auth

import com.entry.persistence.user.UserPersistenceAdapter
import com.entry.persistence.user.mapper.UserMapper
import com.entry.user.model.User
import com.entry.user.port.out.LoadCurrentUserPort
import org.springframework.security.core.context.SecurityContextHolder

class SecurityAdapter(
    val userPersistenceAdapter: UserPersistenceAdapter,
): LoadCurrentUserPort{

    override fun load(): User {
        val userEmail = SecurityContextHolder.getContext().authentication.name
        return userPersistenceAdapter.findUserByEmail(userEmail)
    }

}