package com.entry.persistence.user.entity

import com.entry.persistence.BaseUUIDEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_user")
class UserJpaEntity(
    id: UUID?,

    @Column(name = "email", nullable = false, length = 100)
    val email: String,

    @Column(name = "nickname", nullable = false, length = 100)
    val nickname: String

): BaseUUIDEntity(id)