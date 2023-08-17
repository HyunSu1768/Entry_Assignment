package com.entry.persistence

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(

    id: UUID?,

    @CreatedDate
    private val createdAt: LocalDateTime? = LocalDateTime.now()
): BaseUUIDEntity(id)