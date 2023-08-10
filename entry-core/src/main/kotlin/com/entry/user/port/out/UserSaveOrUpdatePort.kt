package com.entry.user.port.out

import com.entry.user.model.User


interface UserSaveOrUpdatePort {

    fun saveOrUpdate(user: User)
}