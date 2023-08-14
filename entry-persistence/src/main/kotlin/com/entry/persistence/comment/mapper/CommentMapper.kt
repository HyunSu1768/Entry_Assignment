package com.entry.persistence.comment.mapper

import com.entry.comment.model.Comment
import com.entry.persistence.comment.entity.CommentJpaEntity
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.user.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class CommentMapper(
    private val userMapper: UserMapper,
    private val feedMapper: FeedMapper
) {

    fun toEntity(comment: Comment): CommentJpaEntity{

        return CommentJpaEntity(
            id = comment.id,
            content = comment.content,
            user = userMapper.toEntity(comment.user),
            feed = feedMapper.toEntity(comment.feed)
        )
    }

    fun toDomain(commentJpaEntity: CommentJpaEntity): Comment{

        return Comment(
            id = commentJpaEntity.id,
            content = commentJpaEntity.content,
            user = userMapper.toDomain(commentJpaEntity.user),
            feed = feedMapper.toDomain(commentJpaEntity.feed)
        )
    }
}