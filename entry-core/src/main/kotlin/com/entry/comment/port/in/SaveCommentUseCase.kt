package com.entry.comment.port.`in`

import com.entry.comment.dto.request.CommentRequest
import java.util.UUID

interface SaveCommentUseCase {

    fun saveComment(commentRequest: CommentRequest, feedId: UUID)
}