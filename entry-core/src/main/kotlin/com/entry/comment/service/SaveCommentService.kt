package com.entry.comment.service

import com.entry.comment.dto.request.CommentRequest
import com.entry.comment.model.Comment
import com.entry.comment.port.`in`.SaveCommentUseCase
import com.entry.comment.port.out.SaveCommentPort
import com.entry.common.UseCase
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.user.port.out.LoadCurrentUserPort
import java.util.UUID

@UseCase
class SaveCommentService(
    private val saveCommentPort: SaveCommentPort,
    private val loadCurrentUserPort: LoadCurrentUserPort,
    private val loadFeedByUUIDPort: LoadFeedByUUIDPort
): SaveCommentUseCase {

    override fun saveComment(commentRequest: CommentRequest, feedId: UUID) {

        val user = loadCurrentUserPort.loadCurrentUser()

        val feed = loadFeedByUUIDPort.loadFeed(feedId)

        val comment = Comment(
            id = null,
            content = commentRequest.content,
            user = user,
            feed = feed
        )

        saveCommentPort.saveComment(comment)
    }
}