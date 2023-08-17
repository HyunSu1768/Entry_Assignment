package com.entry.common.error

enum class ErrorCode(
    val statusCode: Int,
    val message: String
) {

    // UnAuthorized
    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),

    // Interval Server Error
    INTERVAL_SERVER_ERROR(500, "Interval Server Error"),

    // 404 Not Found
    FEED_NOT_FOUND(404, "찾을 수 없는 피드입니다."),
    STOCK_NOT_FOUND(404, "찾을 수 없는 주식입니다."),
    RECENT_FEED_NOT_FOUND(404, "최근 읽은 피드를 찾을 수 없습니다."),

    // 403 Forbidden
    WRITER_MISMATCH(403, "작성자만 수정할 수 있습니다.")
}