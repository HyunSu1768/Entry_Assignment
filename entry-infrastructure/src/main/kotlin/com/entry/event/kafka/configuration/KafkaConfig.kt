package com.entry.event.kafka.configuration

import com.entry.feed.dto.request.FeedEventRequest
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaConfig(
    private val kafkaProperty: KafkaProperty
) {

    @Bean
    fun loadFeedConsumerFactory(): ConsumerFactory<String, FeedEventRequest> {
        return DefaultKafkaConsumerFactory(
            consumerConfig(),
            StringDeserializer(),
            JsonDeserializer(FeedEventRequest::class.java)
        )
    }

    @Bean
    fun loadFeedListener(): ConcurrentKafkaListenerContainerFactory<String, FeedEventRequest> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, FeedEventRequest>()
        factory.consumerFactory = loadFeedConsumerFactory()
        return factory
    }

    @Bean
    fun loadFeedProducerFactory(): DefaultKafkaProducerFactory<String, FeedEventRequest> {
        return DefaultKafkaProducerFactory(producerConfig())
    }

    @Bean
    fun loadFeedKafkaTemplate(): KafkaTemplate<String, FeedEventRequest> {
        return KafkaTemplate(loadFeedProducerFactory())
    }

    private fun consumerConfig(): MutableMap<String, Any> {
        val configs: MutableMap<String, Any> = HashMap<String, Any>()
        configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperty.serverAddress
        configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return configs
    }

    private fun producerConfig(): MutableMap<String, Any> {
        val configs: MutableMap<String, Any> = HashMap<String, Any>()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperty.serverAddress
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        return configs
    }
}