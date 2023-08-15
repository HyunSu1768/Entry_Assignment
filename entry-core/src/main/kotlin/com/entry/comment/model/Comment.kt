package com.entry.comment.model

import com.entry.feed.model.Feed
import com.entry.stock.model.Stock
import com.entry.user.model.User
import java.util.UUID

class Comment(

    val id: UUID?,

    val content: String,

    val user: User,

    val feed: Feed
)