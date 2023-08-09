package com.entry.feed.port.`in`

import com.entry.feed.dto.request.FeedRequest

interface SaveFeedUseCase {
    fun saveFeed(feedRequest: FeedRequest)
}