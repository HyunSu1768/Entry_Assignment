package com.entry.feed

import com.entry.common.WebAdapter
import com.entry.feed.dto.request.FeedModifyRequest
import com.entry.feed.dto.request.FeedModifyWebRequest
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.dto.request.FeedWebRequest
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.dto.response.FeedResponse
import com.entry.feed.port.`in`.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/feed")
@WebAdapter
class FeedWebAdapter(
    private val saveFeedUseCase: SaveFeedUseCase,
    private val loadFeedListUseCase: LoadFeedListUseCase,
    private val modifyFeedUseCase: ModifyFeedUseCase,
    private val removeFeedUseCase: RemoveFeedUseCase,
    private val loadFeedListByStockUseCase: LoadFeedListByStockUseCase,
    private val loadFeedByUUIDUseCase: LoadFeedByUUIDUseCase,
    private val recentViewFeedUseCase: LoadRecentViewFeedUseCase
) {

    @GetMapping("/{feedId}")
    fun loadFeed(@PathVariable feedId: UUID): FeedResponse = loadFeedByUUIDUseCase.loadFeed(feedId)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addFeed(@RequestBody feedWebRequest: FeedWebRequest) {

        saveFeedUseCase.saveFeed(
            FeedRequest(
                feedWebRequest.title,
                feedWebRequest.content,
                feedWebRequest.stockId
            )
        )
    }

    @GetMapping("/list")
    fun findFeedList(): FeedListResponse = loadFeedListUseCase.loadFeed()

    @PutMapping("/{feedId}")
    fun modifyFeed(@PathVariable feedId: UUID, @RequestBody feedModifyWebRequest: FeedModifyWebRequest){
        modifyFeedUseCase.modifyFeed(
            FeedModifyRequest(
                feedModifyWebRequest.title,
                feedModifyWebRequest.content
            ), feedId
        )
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feedId}")
    fun deleteFeed(@PathVariable feedId: UUID) = removeFeedUseCase.removeFeed(feedId)

    @GetMapping("/list/{stockId}")
    fun findFeedListByStock(@PathVariable stockId: String): FeedListResponse
        = loadFeedListByStockUseCase.loadFeedListByStock(stockId)

    @GetMapping("/recent-viewed-feed")
    fun recentViewFeed(): FeedResponse{
        return recentViewFeedUseCase.loadRecentFeed()
    }

}