package com.entry.user.port.out

import com.entry.user.model.User

interface LoadCurrentUserPort {

    fun loadCurrentUser(): User
}