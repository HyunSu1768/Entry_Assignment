package com.entry.feed.service

import com.entry.comment.port.out.LoadCommentListByFeedPort
import com.entry.common.UseCase
import com.entry.feed.dto.request.FeedEventRequest
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.model.Feed
import com.entry.feed.port.`in`.LoadFeedByUUIDUseCase
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.feed.port.out.LoadFeedEventPort
import com.entry.user.port.out.LoadCurrentUserPort
import java.util.*

@UseCase
class LoadFeedByUUIDService(
    private val loadFeedByUUIDPort: LoadFeedByUUIDPort,
    private val commentListByFeedPort: LoadCommentListByFeedPort,
    private val loadFeedEventPort: LoadFeedEventPort,
    private val loadCurrentUserPort: LoadCurrentUserPort
): LoadFeedByUUIDUseCase {

    override fun loadFeed(id: UUID): FeedResponse {

        val feed = loadFeedByUUIDPort.loadFeed(id)

        loadFeedEventPort.send(
            FeedEventRequest(
                feed,
                loadCurrentUserPort.loadCurrentUser()
            )
        )

        return FeedResponse(
            id = feed.uuid,
            title = feed.title,
            content = feed.content,
            nickname = feed.user.nickname,
            commentListResponse = commentListByFeedPort.loadCommentList(feed)
        )
    }
}