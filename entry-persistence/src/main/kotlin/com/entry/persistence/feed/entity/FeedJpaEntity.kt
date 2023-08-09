package com.entry.persistence.feed.entity

import com.entry.persistence.user.entity.UserJpaEntity
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.*

@Entity(name = "tbl_feed")
class FeedJpaEntity(

    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val uuid: UUID?,

    val title: String,

    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserJpaEntity

)