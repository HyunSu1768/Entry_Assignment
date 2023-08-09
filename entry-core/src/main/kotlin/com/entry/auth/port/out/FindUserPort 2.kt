package com.entry.auth.port.out

import com.entry.auth.model.User

interface FindUserPort {
    fun findUserByEmail(email: String?): User
}