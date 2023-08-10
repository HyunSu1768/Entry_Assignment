package com.entry.feed.port.`in`

import com.entry.feed.dto.request.FeedModifyRequest
import java.util.UUID

interface ModifyFeedUseCase {

    fun modifyFeed(feedModifyRequest: FeedModifyRequest, id: UUID)
}