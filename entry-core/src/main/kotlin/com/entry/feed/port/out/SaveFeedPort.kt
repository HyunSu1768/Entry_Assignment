package com.entry.feed.port.out

import com.entry.feed.model.Feed

interface SaveFeedPort {

    fun saveFeed(feed: Feed)
}