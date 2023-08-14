package com.entry.persistence.comment.entity

import com.entry.persistence.BaseUUIDEntity
import com.entry.persistence.feed.entity.FeedJpaEntity
import com.entry.persistence.user.entity.UserJpaEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_comment")
class CommentJpaEntity(

    id: UUID?,

    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserJpaEntity,

    @ManyToOne
    @JoinColumn(name = "feed_id")
    val feed: FeedJpaEntity

): BaseUUIDEntity(id)