package com.entry.persistence.feed

import com.entry.comment.port.out.LoadCommentListByFeedPort
import com.entry.common.PersistenceAdapter
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.model.FeedHistory
import com.entry.feed.port.out.LoadRecentViewFeedPort
import com.entry.feed.port.out.SaveFeedHistoryPort
import org.springframework.data.domain.Sort
import com.entry.persistence.feed.mapper.FeedHistoryMapper
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.feed.repository.FeedHistoryRepository
import com.entry.persistence.user.mapper.UserMapper
import com.entry.user.model.User

@PersistenceAdapter
class FeedHistoryPersistenceAdapter(
    private val feedHistoryRepository: FeedHistoryRepository,
    private val feedHistoryMapper: FeedHistoryMapper,
    private val userMapper: UserMapper,
    private val feedMapper: FeedMapper,
    private val loadCommentListByFeedPort: LoadCommentListByFeedPort
): SaveFeedHistoryPort, LoadRecentViewFeedPort {

    override fun saveFeedHistory(feedHistory: FeedHistory) {
        feedHistoryRepository.save(feedHistoryMapper.toEntity(feedHistory))
    }

    override fun loadRecentViewFeed(user: User): FeedResponse {

        val feedHistory =
            feedHistoryRepository.findAllByUserJpaEntity(
                userMapper.toEntity(user),
                Sort.by(Sort.Direction.DESC, "createdAt")
            )

        if(feedHistory.isEmpty()){
            throw BusinessException(ErrorCode.RECENT_FEED_NOT_FOUND)
        }

        val feed = feedMapper.toDomain(feedHistory[0].feedJpaEntity)
        val commentList = loadCommentListByFeedPort.loadCommentList(feed)
        return FeedResponse.of(feed, commentList)
    }
}