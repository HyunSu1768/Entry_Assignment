package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.port.`in`.RemoveFeedUseCase
import com.entry.feed.port.out.RemoveFeedPort
import java.util.*

@UseCase
class RemoveFeedService(
    val removeFeedPort: RemoveFeedPort
): RemoveFeedUseCase {

    override fun removeFeed(uuid: UUID) {
        removeFeedPort.removeFeed(uuid)
    }
}