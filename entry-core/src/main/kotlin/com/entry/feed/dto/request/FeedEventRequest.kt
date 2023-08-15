package com.entry.feed.dto.request

import com.entry.feed.model.Feed
import com.entry.user.model.User

data class FeedEventRequest(

    val feed: Feed,

    val user: User
)