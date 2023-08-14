package com.entry.persistence.feed

import com.entry.comment.port.out.LoadCommentListByFeedPort
import com.entry.common.PersistenceAdapter
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.model.Feed
import com.entry.feed.port.out.*
import com.entry.persistence.feed.mapper.FeedMapper
import com.entry.persistence.feed.repository.FeedRepository
import com.entry.persistence.stock.mapper.StockMapper
import com.entry.stock.model.Stock
import com.entry.stock.port.out.LoadStockPort
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@PersistenceAdapter
class FeedPersistenceAdapterPort(
    val feedRepository: FeedRepository,
    val feedMapper: FeedMapper,
    val loadStockPort: LoadStockPort,
    val stockMapper: StockMapper,
    val loadCommentListByFeedPort: LoadCommentListByFeedPort
): SaveFeedPort, LoadFeedListPort, LoadFeedByUUIDPort, RemoveFeedPort, LoadFeedListByStockPort {

    override fun loadFeedList(): MutableList<FeedResponse> {

        return feedRepository.findAll().stream().map {
                it -> FeedResponse.of(feedMapper.toDomain(it),
                loadCommentListByFeedPort.loadCommentList(feedMapper.toDomain(it)) )
        }.toList()
    }

    override fun loadFeed(uuid: UUID): Feed {

        return feedMapper.toDomain(feedRepository.findById(uuid).orElseThrow{ BusinessException(ErrorCode.FEED_NOT_FOUND)})
    }

    override fun removeFeed(uuid: UUID) = feedRepository.deleteById(uuid)

    override fun saveFeed(feed: Feed){

        feedRepository.save(feedMapper.toEntity(feed))
    }

    override fun loadFeedListByStock(stock: Stock): FeedListResponse {

        val feedResponseList = feedRepository.findAllByStock(
            stockMapper.toEntity(stock)
        ).stream().map {
                it -> FeedResponse.of(feedMapper.toDomain(it),
            loadCommentListByFeedPort.loadCommentList(feedMapper.toDomain(it)) )
        }.toList()
        return FeedListResponse(feedResponseList)
    }
}