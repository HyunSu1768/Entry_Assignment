package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.feed.port.`in`.RemoveFeedUseCase
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.feed.port.out.LoadFeedEventPort
import com.entry.feed.port.out.RemoveFeedPort
import com.entry.user.port.out.LoadCurrentUserPort
import java.util.*

@UseCase
class RemoveFeedService(
    val removeFeedPort: RemoveFeedPort,
    val loadFeedByUUIDPort: LoadFeedByUUIDPort,
    val loadCurrentUserPort: LoadCurrentUserPort
): RemoveFeedUseCase {

    override fun removeFeed(uuid: UUID) {

        val feed = loadFeedByUUIDPort.loadFeed(uuid)
        val user = loadCurrentUserPort.loadCurrentUser()

        if(feed.user != user){
            throw BusinessException(ErrorCode.WRITER_MISMATCH)
        }

        removeFeedPort.removeFeed(uuid)
    }
}