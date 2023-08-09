package com.entry.persistence.user.entity

import org.hibernate.annotations.GenericGenerator
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tbl_user")
class UserJpaEntity(

    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val uuid: UUID?,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "nickname", nullable = false)
    val nickname: String

): UserDetails {

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