package com.entry.feed

import com.entry.common.WebAdapter
import com.entry.feed.dto.request.FeedModifyRequest
import com.entry.feed.dto.request.FeedModifyWebRequest
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.dto.request.FeedWebRequest
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.port.`in`.LoadFeedListUseCase
import com.entry.feed.port.`in`.ModifyFeedUseCase
import com.entry.feed.port.`in`.SaveFeedUseCase
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/feed")
@WebAdapter
class FeedWebAdapter(
    private val saveFeedUseCase: SaveFeedUseCase,
    private val loadFeedListUseCase: LoadFeedListUseCase,
    private val modifyFeedUseCase: ModifyFeedUseCase
) {

    @PostMapping
    fun addFeed(@RequestBody feedWebRequest: FeedWebRequest) {
        saveFeedUseCase.saveFeed(
            FeedRequest(
                feedWebRequest.title,
                feedWebRequest.content
            )
        )
    }

    @GetMapping("/list")
    fun findFeedList(): FeedListResponse{
        return loadFeedListUseCase.loadFeed()
    }

    @PutMapping("/{uuid}")
    fun modifyFeed(@PathVariable uuid: UUID, @RequestBody feedModifyWebRequest: FeedModifyWebRequest){
        modifyFeedUseCase.modifyFeed(
            FeedModifyRequest(
                feedModifyWebRequest.title,
                feedModifyWebRequest.content
            ), uuid
        )
    }

}