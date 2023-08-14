package com.entry.comment.port.out

import com.entry.comment.dto.response.CommentListResponse
import com.entry.feed.model.Feed

interface LoadCommentListByFeedPort {

    fun loadCommentList(feed: Feed): CommentListResponse
}