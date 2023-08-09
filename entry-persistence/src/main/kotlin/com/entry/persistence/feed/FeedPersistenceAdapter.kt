package com.entry.persistence.feed

import com.entry.common.PersistenceAdapter
import com.entry.feed.model.Feed
import com.entry.feed.port.out.SaveFeedPort
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.feed.repository.FeedRepository
import com.entry.user.model.User

@PersistenceAdapter
class FeedPersistenceAdapter(
    val feedRepository: FeedRepository,
    val feedMapper: FeedMapper
): SaveFeedPort {
    override fun save(feed: Feed) {
        val feedJpaEntity = feedMapper.toDomain(feed)
        feedRepository.save(feedJpaEntity)
    }

}