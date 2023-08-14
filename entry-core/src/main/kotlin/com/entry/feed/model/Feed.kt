package com.entry.feed.model

import com.entry.stock.model.Stock
import com.entry.user.model.User
import java.util.UUID

data class Feed(
    val uuid: UUID? = UUID(0,0),
    val title: String,
    val content: String,
    val user: User,
    val stock: Stock
)