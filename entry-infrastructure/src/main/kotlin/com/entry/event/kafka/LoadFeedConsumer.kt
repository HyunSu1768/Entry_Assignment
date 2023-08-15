package com.entry.event.kafka

import com.entry.feed.dto.request.FeedEventRequest
import com.entry.feed.model.FeedHistory
import com.entry.feed.port.out.SaveFeedHistoryPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class LoadFeedConsumer(
    val saveFeedHistoryPort: SaveFeedHistoryPort
) {

    @KafkaListener(topics = ["LOAD_FEED"], groupId = "entry", containerFactory ="loadFeedListener")
    fun recordHistory(feedEventRequest: FeedEventRequest){
        saveFeedHistoryPort.saveFeedHistory(
            FeedHistory(
                id = null,
                feed = feedEventRequest.feed,
                user = feedEventRequest.user
            )
        )
    }
}