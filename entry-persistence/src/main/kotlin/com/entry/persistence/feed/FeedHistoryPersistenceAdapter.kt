package com.entry.persistence.feed

import com.entry.common.PersistenceAdapter
import com.entry.feed.model.FeedHistory
import com.entry.feed.port.out.SaveFeedHistoryPort
import com.entry.persistence.feed.mapper.FeedHistoryMapper
import com.entry.persistence.feed.repository.FeedHistoryRepository

@PersistenceAdapter
class FeedHistoryPersistenceAdapter(
    private val feedHistoryRepository: FeedHistoryRepository,
    private val feedHistoryMapper: FeedHistoryMapper
): SaveFeedHistoryPort {

    override fun saveFeedHistory(feedHistory: FeedHistory) {
        feedHistoryRepository.save(feedHistoryMapper.toEntity(feedHistory))
    }
}