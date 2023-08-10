package com.entry.persistence.feed

import com.entry.common.PersistenceAdapter
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.model.Feed
import com.entry.feed.port.out.LoadFeedByUUIDPort
import com.entry.feed.port.out.LoadFeedListPort
import com.entry.feed.port.out.SaveFeedPort
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.feed.repository.FeedRepository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@PersistenceAdapter
class FeedPersistenceAdapterPort(
    val feedRepository: FeedRepository,
    val feedMapper: FeedMapper
): SaveFeedPort, LoadFeedListPort, LoadFeedByUUIDPort {

    override fun saveFeed(feed: Feed) {
        val feedJpaEntity = feedMapper.toDomain(feed)
        feedRepository.save(feedJpaEntity)
    }

    override fun loadFeedList(): MutableList<FeedResponse> {
        return feedRepository.findAll().stream().map { it -> FeedResponse.of(feedMapper.toEntity(it)) }.toList()
    }

    override fun loadFeed(uuid: UUID): Feed {
        return feedMapper.toEntity(feedRepository.findById(uuid).orElseThrow{ BusinessException(ErrorCode.FEED_NOT_FOUND)})
    }

}