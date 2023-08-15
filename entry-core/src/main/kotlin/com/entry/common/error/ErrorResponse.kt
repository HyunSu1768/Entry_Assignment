package com.entry.common.error

import java.time.LocalDateTime

data class ErrorResponse(
    val message: String?,
    val status: Int?,
    val timestamp: LocalDateTime?,
    val description: String?
) {

    companion object{

        fun of(errorCode: ErrorCode, description: String?): ErrorResponse{
            return ErrorResponse(
                errorCode.message,
                errorCode.statusCode,
                timestamp = LocalDateTime.now(),
                description
            )
        }

        fun of(errorCode: Int, description: String?): ErrorResponse{
            return ErrorResponse(
                description,
                errorCode,
                LocalDateTime.now(),
                description
            )
        }

        fun of(e: Exception): ErrorResponse{
            return ErrorResponse(
                "Interval Server Error",
                500,
                LocalDateTime.now(),
                "서버오류"
            )
        }
    }
}