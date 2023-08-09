package com.entry.persistence.feed

import com.entry.common.PersistenceAdapter
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.model.Feed
import com.entry.feed.port.out.LoadFeedListPort
import com.entry.feed.port.out.SaveFeedPort
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.feed.repository.FeedRepository
import com.entry.user.model.User
import kotlin.streams.toList

@PersistenceAdapter
class FeedPersistenceAdapter(
    val feedRepository: FeedRepository,
    val feedMapper: FeedMapper
): SaveFeedPort, LoadFeedListPort {

    override fun save(feed: Feed) {
        val feedJpaEntity = feedMapper.toDomain(feed)
        feedRepository.save(feedJpaEntity)
    }

    override fun load(): MutableList<FeedResponse> {
        return feedRepository.findAll().stream().map { it -> FeedResponse.of(feedMapper.toEntity(it)) }.toList()
    }

}