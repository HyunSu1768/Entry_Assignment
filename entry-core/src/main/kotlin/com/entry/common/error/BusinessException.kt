package com.entry.common.error

import java.lang.RuntimeException

abstract class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()