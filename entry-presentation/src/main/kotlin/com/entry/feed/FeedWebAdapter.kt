package com.entry.feed

import com.entry.common.WebAdapter
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.dto.request.FeedWebRequest
import com.entry.feed.dto.response.FeedListResponse
import com.entry.feed.port.`in`.LoadFeedListUseCase
import com.entry.feed.port.`in`.SaveFeedUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feed")
@WebAdapter
class FeedWebAdapter(
    private val saveFeedUseCase: SaveFeedUseCase,
    private val loadFeedListUseCase: LoadFeedListUseCase
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
        return loadFeedListUseCase.load()
    }

}