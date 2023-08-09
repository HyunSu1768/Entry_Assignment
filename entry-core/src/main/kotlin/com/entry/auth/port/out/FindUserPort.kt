package com.entry.auth.port.out

import com.entry.user.model.User

interface FindUserPort {
    fun findUserByEmail(email: String?): User
}