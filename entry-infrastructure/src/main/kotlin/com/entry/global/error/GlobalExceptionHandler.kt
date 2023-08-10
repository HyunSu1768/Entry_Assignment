package com.entry.global.error

import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.common.error.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse>{
        val errorCode = e.errorCode
        val response: ErrorResponse = ErrorResponse.of(errorCode, errorCode.message)

        return ResponseEntity(response, HttpStatus.valueOf(errorCode.statusCode))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse>{
        val errorCode = ErrorCode.INTERVAL_SERVER_ERROR
        val response = ErrorResponse.of(errorCode, e.message)

        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}