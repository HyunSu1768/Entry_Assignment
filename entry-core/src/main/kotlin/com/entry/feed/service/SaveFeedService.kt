package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.model.Feed
import com.entry.feed.port.`in`.SaveFeedUseCase
import com.entry.feed.port.out.SaveFeedPort
import com.entry.user.port.out.LoadCurrentUserPort

@UseCase
class SaveFeedService(
    val saveFeedPort: SaveFeedPort,
    val loadCurrentUserPort: LoadCurrentUserPort
): SaveFeedUseCase {

    override fun saveFeed(request: FeedRequest) {

        val feed = Feed(
            title = request.title,
            content = request.content,
            user = loadCurrentUserPort.load()
        )

        saveFeedPort.save(feed)
    }

}