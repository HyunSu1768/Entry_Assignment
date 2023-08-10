package com.entry.feed.port.out

import com.entry.feed.model.Feed
import com.entry.user.model.User

interface SaveFeedPort {

    fun save(feed: Feed)
}