package com.entry.feed.model

import com.entry.user.model.User
import java.util.*

data class FeedHistory(

    val id: UUID?,

    val feed: Feed,

    val user: User
)