package com.entry.common.error

import java.lang.RuntimeException

class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()