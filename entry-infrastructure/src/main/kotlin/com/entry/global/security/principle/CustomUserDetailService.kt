package com.entry.global.security.principle

import com.entry.user.port.out.FindUserPort
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class CustomUserDetailService(
    val findUserPort: FindUserPort
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = findUserPort.findUserByEmail(username)
        return CustomUserDetails(user)
    }
}