package com.entry.feed.port.out

import java.util.UUID

interface RemoveFeedPort {
    fun removeFeed(uuid: UUID)
}