package com.entry.persistence.comment

import com.entry.comment.model.Comment
import com.entry.comment.port.out.SaveCommentPort
import com.entry.common.PersistenceAdapter
import com.entry.persistence.comment.mapper.CommentMapper
import com.entry.persistence.comment.repository.CommentRepository

@PersistenceAdapter
class CommentPersistenceAdapter(
    private val commentRepository: CommentRepository,
    private val commentMapper: CommentMapper
): SaveCommentPort {

    override fun saveComment(comment: Comment) {

        commentRepository.save(commentMapper.toEntity(comment))
    }
}