package com.entry.stock.service

import com.entry.common.UseCase
import com.entry.stock.dto.response.StockListResponse
import com.entry.stock.port.`in`.LoadStockListUseCase
import com.entry.stock.port.out.LoadStockListPort

@UseCase
class LoadStockListService(
    val loadStockListPort: LoadStockListPort
): LoadStockListUseCase {

    override fun loadStockList(): StockListResponse {
        return loadStockListPort.loadStockList()
    }
}