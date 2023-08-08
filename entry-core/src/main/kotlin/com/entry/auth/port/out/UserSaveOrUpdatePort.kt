package com.entry.auth.port.out

import com.entry.auth.model.User


interface UserSaveOrUpdatePort {

    fun saveOrUpdate(user: User)

}