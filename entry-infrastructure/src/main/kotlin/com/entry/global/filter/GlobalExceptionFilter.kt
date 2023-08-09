package com.entry.global.filter

import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class GlobalExceptionFilter(
    val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch(e: BusinessException){
            val errorCode = e.errorCode
            writeErrorResponse(response, errorCode.statusCode, ErrorResponse.of(errorCode, errorCode.message))
        }
    }

    private fun writeErrorResponse(
        response: HttpServletResponse,
        response1: Int,
        response2: ErrorResponse
    ){
        response.status = response1
        response.contentType = "application.json"
        response.characterEncoding = "UTF-8"
        objectMapper.writeValue(response.writer, response2)
    }

}