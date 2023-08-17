package com.entry.feed.port.`in`

import com.entry.feed.dto.response.FeedResponse

interface LoadRecentViewFeedUseCase {

    fun loadRecentFeed(): FeedResponse
}