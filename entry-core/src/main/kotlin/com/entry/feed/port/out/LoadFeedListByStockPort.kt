package com.entry.feed.port.out

import com.entry.feed.dto.response.FeedListResponse
import com.entry.stock.model.Stock

interface LoadFeedListByStockPort {

    fun loadFeedListByStock(stock: Stock): FeedListResponse
}