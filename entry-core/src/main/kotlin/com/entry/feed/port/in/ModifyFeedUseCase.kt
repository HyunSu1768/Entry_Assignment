package com.entry.feed.port.`in`

import com.entry.feed.dto.request.FeedModifyRequest
import java.util.UUID

interface ModifyFeedUseCase {

    fun modify(feedModifyRequest: FeedModifyRequest, id: UUID)
}