package com.entry.persistence.feed.entity

import com.entry.persistence.BaseUUIDEntity
import com.entry.persistence.stock.entity.StockJpaEntity
import com.entry.persistence.user.entity.UserJpaEntity
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.*

@Entity(name = "tbl_feed")
class FeedJpaEntity(

    id: UUID?,

    @Column(name = "title", nullable = false, length = 100)
    val title: String,

    @Column(name = "content", nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    val stock: StockJpaEntity

): BaseUUIDEntity(id)