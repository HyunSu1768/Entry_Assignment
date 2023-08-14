package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.port.`in`.LoadFeedListByStockUseCase
import com.entry.feed.port.out.LoadFeedListByStockPort
import com.entry.stock.port.out.LoadStockPort

@UseCase
class LoadFeedByStockService(
    private val loadFeedListByStockPort: LoadFeedListByStockPort,
    private val loadStockPort: LoadStockPort
): LoadFeedListByStockUseCase {

    override fun loadFeedListByStock(stockId: String): FeedListResponse {

        val stock = loadStockPort.loadStock(stockId)
        return loadFeedListByStockPort.loadFeedListByStock(stock)
    }
}