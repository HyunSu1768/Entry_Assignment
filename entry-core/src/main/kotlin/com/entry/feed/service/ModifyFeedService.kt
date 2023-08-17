package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.feed.dto.request.FeedModifyRequest
import com.entry.feed.port.`in`.ModifyFeedUseCase
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.feed.port.out.SaveFeedPort
import com.entry.user.port.out.LoadCurrentUserPort
import java.util.*

@UseCase
class ModifyFeedService(
    private val loadFeedByUUIDPort: LoadFeedByUUIDPort,
    private val saveFeedPort: SaveFeedPort,
    private val loadCurrentUserPort: LoadCurrentUserPort
    ): ModifyFeedUseCase{

    override fun modifyFeed(feedModifyRequest: FeedModifyRequest, id: UUID) {

        val feed = loadFeedByUUIDPort.loadFeed(id)

        val user = loadCurrentUserPort.loadCurrentUser()

        if(feed.user!=user){
            throw BusinessException(ErrorCode.WRITER_MISMATCH)
        }

        saveFeedPort.saveFeed(
            feed.copy(
                title = feedModifyRequest.title,
                content = feedModifyRequest.content
            )
        )
    }
}