package com.entry.persistence.feed.repository

import com.entry.persistence.feed.entity.FeedJpaEntity
import com.entry.persistence.stock.entity.StockJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FeedRepository : JpaRepository<FeedJpaEntity, UUID> {

    fun findAllByStock(stockJpaEntity: StockJpaEntity): MutableList<FeedJpaEntity>
}