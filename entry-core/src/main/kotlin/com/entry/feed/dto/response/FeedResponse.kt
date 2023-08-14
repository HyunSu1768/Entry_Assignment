package com.entry.feed.dto.response

import com.entry.comment.dto.response.CommentListResponse
import com.entry.feed.model.Feed
import java.util.UUID

data class FeedResponse(
    val id: UUID?,
    val title: String,
    val content: String,
    val nickname: String,
    val commentListResponse: CommentListResponse
){
    
    companion object{

        fun of(feed: Feed, commentListResponse: CommentListResponse): FeedResponse{

            return FeedResponse(
                feed.uuid,
                feed.title,
                feed.content,
                feed.user.nickname,
                commentListResponse
            )
        }
    }
}