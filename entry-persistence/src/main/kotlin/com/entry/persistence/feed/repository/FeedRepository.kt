package com.entry.persistence.feed.repository

import com.entry.persistence.feed.entity.FeedJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<FeedJpaEntity, Long> {
}