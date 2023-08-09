package com.entry.common.error

import java.time.LocalDateTime

class ErrorResponse(
    private val message: String?,
    private val status: Int?,
    private val timestamp: LocalDateTime?,
    private val description: String?
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