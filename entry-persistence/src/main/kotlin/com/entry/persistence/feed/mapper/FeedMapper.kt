package com.entry.persistence.feed.mapper

import com.entry.feed.model.Feed
import com.entry.persistence.feed.entity.FeedJpaEntity
import com.entry.persistence.user.mapper.UserMapper
import com.entry.user.model.User
import org.springframework.stereotype.Component

@Component
class FeedMapper(
    private val userMapper: UserMapper
) {

    fun toDomain(feed: Feed): FeedJpaEntity{

        val userJpaEntity = userMapper.toDomain(feed.user)

        return FeedJpaEntity(
            uuid = feed.uuid,
            title = feed.title,
            content = feed.content,
            user = userJpaEntity
        )

    }

}