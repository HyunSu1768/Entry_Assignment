package com.entry.user.model

import java.util.*

data class User(
    val uuid: UUID? = UUID(0,0),
    val email: String,
    val nickname: String
) {

}