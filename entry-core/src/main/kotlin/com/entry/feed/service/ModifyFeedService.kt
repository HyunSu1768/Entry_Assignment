package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.request.FeedModifyRequest
import com.entry.feed.port.`in`.ModifyFeedUseCase
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.feed.port.out.SaveFeedPort
import java.util.*

@UseCase
class ModifyFeedService(
    private val loadFeedByUUIDPort: LoadFeedByUUIDPort,
    private val saveFeedPort: SaveFeedPort
    ): ModifyFeedUseCase{

    override fun modifyFeed(feedModifyRequest: FeedModifyRequest, id: UUID) {

        val feed = loadFeedByUUIDPort.loadFeed(id)

        saveFeedPort.saveFeed(
            feed.copy(
                title = feedModifyRequest.title,
                content = feedModifyRequest.content
            )
        )
    }

}