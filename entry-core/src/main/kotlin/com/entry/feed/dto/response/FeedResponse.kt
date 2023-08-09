package com.entry.feed.dto.response

import com.entry.feed.model.Feed

data class FeedResponse(
    val title: String,
    val content: String,
    val nickname: String
){
    companion object{

        fun of(feed: Feed): FeedResponse{
            return FeedResponse(
                feed.title,
                feed.content,
                feed.user.nickname
            )
        }

    }
}