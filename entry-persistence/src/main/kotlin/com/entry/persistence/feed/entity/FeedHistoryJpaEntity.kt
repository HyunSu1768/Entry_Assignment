package com.entry.persistence.feed.entity

import com.entry.persistence.BaseUUIDEntity
import com.entry.persistence.stock.entity.StockJpaEntity
import com.entry.persistence.user.entity.UserJpaEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity(name = "tbl_feed_history")
class FeedHistoryJpaEntity(

    id: UUID?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userJpaEntity: UserJpaEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    val feedJpaEntity: FeedJpaEntity

): BaseUUIDEntity(id)