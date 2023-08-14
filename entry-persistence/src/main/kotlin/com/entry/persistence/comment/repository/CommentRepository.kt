package com.entry.persistence.comment.repository

import com.entry.persistence.comment.entity.CommentJpaEntity
import com.entry.persistence.feed.entity.FeedJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CommentRepository : JpaRepository<CommentJpaEntity, UUID> {

    fun findAllByFeed(feedJpaEntity: FeedJpaEntity): MutableList<CommentJpaEntity>
}