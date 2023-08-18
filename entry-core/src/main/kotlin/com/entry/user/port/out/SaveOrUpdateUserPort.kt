package com.entry.user.port.out

import com.entry.user.model.User


interface SaveOrUpdateUserPort {

    fun saveOrUpdate(user: User)
}