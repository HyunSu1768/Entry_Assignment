package com.entry.persistence.user.entity

import com.entry.persistence.BaseUUIDEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_user")
class UserJpaEntity(
    id: UUID?,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "nickname", nullable = false)
    val nickname: String

): BaseUUIDEntity(id) ,UserDetails {

    fun update(nickname: String){

    }

    override fun getAuthorities(): MutableCollection<GrantedAuthority> {
        return arrayListOf(SimpleGrantedAuthority("ROLE_TEST"))
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        return nickname
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