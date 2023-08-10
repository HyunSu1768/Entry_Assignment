package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.port.`in`.LoadFeedListUseCase
import com.entry.feed.port.out.LoadFeedListPort

@UseCase
class LoadFeedListService(
    private val loadFeedListPort: LoadFeedListPort
): LoadFeedListUseCase {

    override fun loadFeed(): FeedListResponse {
        val feedList = loadFeedListPort.loadFeedList()
        return FeedListResponse(feedList)
    }

}