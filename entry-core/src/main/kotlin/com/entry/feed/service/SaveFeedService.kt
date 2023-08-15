package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.model.Feed
import com.entry.feed.port.`in`.SaveFeedUseCase
import com.entry.feed.port.out.SaveFeedPort
import com.entry.stock.port.out.LoadStockPort
import com.entry.user.port.out.LoadCurrentUserPort

@UseCase
class SaveFeedService(
    val saveFeedPort: SaveFeedPort,
    val loadCurrentUserPort: LoadCurrentUserPort,
    val loadStockPort: LoadStockPort
): SaveFeedUseCase {

    override fun saveFeed(request: FeedRequest) {

        val stock = loadStockPort.loadStock(request.stockId)

        val feed = Feed(
            title = request.title,
            content = request.content,
            user = loadCurrentUserPort.loadCurrentUser(),
            stock = stock
        )

        saveFeedPort.saveFeed(feed)
    }
}