package com.entry.auth.port.out

interface JwtExpiredCheckPort {

    fun getSubjectWithExpiredCheck(token: String): String
}