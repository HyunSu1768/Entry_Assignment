package com.entry.feed.port.out

import com.entry.feed.model.FeedHistory

interface SaveFeedHistoryPort {

    fun saveFeedHistory(feedHistory: FeedHistory)
}