package com.entry.persistence.feed.repository

import com.entry.persistence.feed.entity.FeedHistoryJpaEntity
import com.entry.persistence.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.domain.Sort
import java.util.UUID

interface FeedHistoryRepository: JpaRepository<FeedHistoryJpaEntity, UUID> {


    fun findAllByUserJpaEntity(user: UserJpaEntity, sort: Sort): List<FeedHistoryJpaEntity>
}