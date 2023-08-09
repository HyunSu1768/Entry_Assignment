package com.entry.feed

import com.entry.common.WebAdapter
import com.entry.feed.dto.request.FeedRequest
import com.entry.feed.port.`in`.SaveFeedUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feed")
@WebAdapter
class FeedWebAdapter(
    private val saveFeedUseCase: SaveFeedUseCase
) {

    @PostMapping
    fun addFeed(@RequestBody feedRequest: FeedRequest){
        saveFeedUseCase.saveFeed(feedRequest)
    }

}