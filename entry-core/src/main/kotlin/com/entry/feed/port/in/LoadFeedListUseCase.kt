package com.entry.feed.port.`in`

import com.entry.feed.dto.response.FeedListResponse

interface LoadFeedListUseCase {

    fun load(): FeedListResponse
}