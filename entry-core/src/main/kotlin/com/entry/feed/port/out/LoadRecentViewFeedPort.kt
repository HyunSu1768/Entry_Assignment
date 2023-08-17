package com.entry.feed.port.out

import com.entry.feed.dto.response.FeedResponse
import com.entry.user.model.User

interface LoadRecentViewFeedPort {

    fun loadRecentViewFeed(user: User): FeedResponse
}