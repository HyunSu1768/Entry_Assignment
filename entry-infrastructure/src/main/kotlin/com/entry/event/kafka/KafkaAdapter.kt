package com.entry.event.kafka

import com.entry.feed.dto.request.FeedEventRequest
import com.entry.feed.port.out.LoadFeedEventPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaAdapter(
    val saveFeedKafkaTemplate: KafkaTemplate<String, FeedEventRequest>
): LoadFeedEventPort {

    override fun send(feedEventRequest: FeedEventRequest) {

        saveFeedKafkaTemplate.send("LOAD_FEED", feedEventRequest)
    }
}