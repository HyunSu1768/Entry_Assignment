package com.entry.persistence.feed.mapper

import com.entry.feed.model.Feed
import com.entry.persistence.feed.entity.FeedJpaEntity
import com.entry.persistence.stock.mapper.StockMapper
import com.entry.persistence.user.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class FeedMapper(
    private val userMapper: UserMapper,
    private val stockMapper: StockMapper
) {

    fun toEntity(feed: Feed): FeedJpaEntity{

        val userJpaEntity = userMapper.toDomain(feed.user)

        return FeedJpaEntity(
            id = feed.uuid,
            title = feed.title,
            content = feed.content,
            user = userJpaEntity,
            stock = stockMapper.toEntity(feed.stock)
        )
    }

    fun toDomain(feedJpaEntity: FeedJpaEntity): Feed{

        val userEntity = userMapper.toEntity(feedJpaEntity.user)

        return Feed(
            uuid = feedJpaEntity.id,
            title = feedJpaEntity.title,
            content = feedJpaEntity.content,
            user = userEntity,
            stock = stockMapper.toDomain(feedJpaEntity.stock)
        )
    }

}