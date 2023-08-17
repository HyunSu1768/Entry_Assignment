package com.entry.feed.service

import com.entry.common.UseCase
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.port.`in`.LoadRecentViewFeedUseCase
import com.entry.feed.port.out.LoadRecentViewFeedPort
import com.entry.user.port.out.LoadCurrentUserPort

@UseCase
class LoadRecentViewFeedService(
    private val loadRecentViewFeedPort: LoadRecentViewFeedPort,
    private val loadCurrentUserPort: LoadCurrentUserPort
): LoadRecentViewFeedUseCase {

    override fun loadRecentFeed(): FeedResponse {

        val user = loadCurrentUserPort.loadCurrentUser()
        return loadRecentViewFeedPort.loadRecentViewFeed(user)
    }
}