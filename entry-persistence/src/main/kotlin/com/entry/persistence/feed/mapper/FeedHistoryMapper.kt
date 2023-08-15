package com.entry.persistence.feed.mapper

import com.entry.feed.model.FeedHistory
import com.entry.persistence.feed.entity.FeedHistoryJpaEntity
import com.entry.persistence.stock.mapper.StockMapper
import com.entry.persistence.user.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class FeedHistoryMapper(
    private val userMapper: UserMapper,
    private val feedMapper: FeedMapper
) {

    fun toEntity(feedHistory: FeedHistory): FeedHistoryJpaEntity {
        return FeedHistoryJpaEntity(
            id = feedHistory.id,
            userJpaEntity = userMapper.toEntity(feedHistory.user),
            feedJpaEntity = feedMapper.toEntity(feedHistory.feed)
        )
    }

    fun toDomain(feedHistoryJpaEntity: FeedHistoryJpaEntity): FeedHistory {
        return FeedHistory(
            id = feedHistoryJpaEntity.id,
            user = userMapper.toDomain(feedHistoryJpaEntity.userJpaEntity),
            feed = feedMapper.toDomain(feedHistoryJpaEntity.feedJpaEntity)
        )
    }
}