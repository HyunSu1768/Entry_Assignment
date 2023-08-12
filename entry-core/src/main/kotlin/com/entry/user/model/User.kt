package com.entry.user.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

data class User(
    val uuid: UUID? = UUID(0,0),
    val email: String,
    val nickname: String
): UserDetails {

    override fun getAuthorities(): MutableCollection<GrantedAuthority> {
        return arrayListOf(SimpleGrantedAuthority("ROLE_TEST"))
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return false
    }

    override fun isAccountNonLocked(): Boolean {
        return false
    }

    override fun isCredentialsNonExpired(): Boolean {
        return false
    }

    override fun isEnabled(): Boolean {
        return true

    }
}