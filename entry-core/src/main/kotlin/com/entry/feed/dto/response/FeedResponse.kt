package com.entry.feed.dto.response

import com.entry.feed.model.Feed
import java.util.UUID

data class FeedResponse(
    val id: UUID?,
    val title: String,
    val content: String,
    val nickname: String
){
    companion object{

        fun of(feed: Feed): FeedResponse{
            return FeedResponse(
                feed.uuid,
                feed.title,
                feed.content,
                feed.user.nickname
            )
        }

    }
}