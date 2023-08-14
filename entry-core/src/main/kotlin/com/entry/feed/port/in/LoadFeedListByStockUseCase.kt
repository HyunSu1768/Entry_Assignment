package com.entry.feed.port.`in`

import com.entry.feed.dto.response.FeedListResponse

interface LoadFeedListByStockUseCase {

    fun loadFeedListByStock(stockId: String): FeedListResponse
}