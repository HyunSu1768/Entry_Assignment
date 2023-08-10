package com.entry.feed.port.out

import com.entry.feed.model.Feed
import java.util.UUID

interface LoadFeedByUUIDPort {

    fun load(uuid: UUID): Feed
}