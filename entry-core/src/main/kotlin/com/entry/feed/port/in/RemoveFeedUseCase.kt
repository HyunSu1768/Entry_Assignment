package com.entry.feed.port.`in`

import java.util.UUID

interface RemoveFeedUseCase {

    fun removeFeed(uuid: UUID)
}