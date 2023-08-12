package com.entry.stock.port.out

import com.entry.stock.dto.response.StockListResponse

interface LoadStockListPort {

    fun loadStockList(): StockListResponse;
}