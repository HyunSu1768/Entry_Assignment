package com.entry.auth.port.out

import com.entry.auth.dto.response.TokenResponse

interface GenerateJwtPort {

    fun generateToken(email: String): TokenResponse

}