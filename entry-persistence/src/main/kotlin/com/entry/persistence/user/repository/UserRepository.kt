package com.entry.persistence.user.repository

import com.entry.persistence.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<UserJpaEntity, Long>{

    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String?): UserJpaEntity
}