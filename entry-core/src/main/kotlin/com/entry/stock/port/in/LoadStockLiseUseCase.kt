package com.entry.stock.port.`in`

import com.entry.stock.dto.response.StockListResponse

interface LoadStockLiseUseCase {

    fun loadStockList(): StockListResponse;
}