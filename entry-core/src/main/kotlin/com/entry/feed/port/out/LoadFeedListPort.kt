package com.entry.feed.port.out

import com.entry.feed.dto.response.FeedResponse

interface LoadFeedListPort {
    fun load(): MutableList<FeedResponse>
}