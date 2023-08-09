package com.entry.common.error

enum class ErrorCode(
    val statusCode: Int,
    val message: String
) {

    // UnAuthorized
    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),


    // Interval Server Error
    INTERVAL_SERVER_ERROR(500, "Interval Server Error")

}