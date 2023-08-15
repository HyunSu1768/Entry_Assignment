package com.entry.persistence.comment

import com.entry.comment.dto.response.CommentListResponse
import com.entry.comment.dto.response.CommentResponse
import com.entry.comment.model.Comment
import com.entry.comment.port.out.LoadCommentListByFeedPort
import com.entry.comment.port.out.SaveCommentPort
import com.entry.common.PersistenceAdapter
import com.entry.feed.model.Feed
import com.entry.persistence.comment.mapper.CommentMapper
import com.entry.persistence.comment.repository.CommentRepository
import com.entry.persistence.feed.mapper.FeedMapper

@PersistenceAdapter
class CommentPersistenceAdapter(
    private val commentRepository: CommentRepository,
    private val commentMapper: CommentMapper,
    private val feedMapper: FeedMapper
): SaveCommentPort, LoadCommentListByFeedPort {

    override fun saveComment(comment: Comment) {

        commentRepository.save(commentMapper.toEntity(comment))
    }

    override fun loadCommentList(feed: Feed): CommentListResponse {

        val commentResponseList = commentRepository.findAllByFeed(
            feedMapper.toEntity(feed)
        ).map { it -> CommentResponse.of(commentMapper.toDomain(it)) }.toList()

        return CommentListResponse(
            commentResponseList
        )
    }
}