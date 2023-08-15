package com.entry.feed.port.out

import com.entry.feed.dto.request.FeedEventRequest

interface LoadFeedEventPort {

    fun send(feedEventRequest: FeedEventRequest)
}