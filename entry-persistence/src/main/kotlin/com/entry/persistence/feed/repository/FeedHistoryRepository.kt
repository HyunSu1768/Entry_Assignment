package com.entry.persistence.feed.repository

import com.entry.persistence.feed.entity.FeedHistoryJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FeedHistoryRepository: JpaRepository<FeedHistoryJpaEntity, UUID> {
}