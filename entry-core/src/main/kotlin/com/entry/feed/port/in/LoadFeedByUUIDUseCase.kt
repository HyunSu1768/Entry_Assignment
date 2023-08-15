package com.entry.feed.port.`in`

import com.entry.feed.dto.response.FeedResponse
import java.util.UUID

interface LoadFeedByUUIDUseCase {

    fun loadFeed(id: UUID): FeedResponse
}