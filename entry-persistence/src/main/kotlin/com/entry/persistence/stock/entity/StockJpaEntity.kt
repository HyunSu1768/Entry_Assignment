package com.entry.persistence.stock.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tbl_stock")
data class StockJpaEntity(

    @Id
    @Column(length = 100)
    val id: String?,

    val stockName: String,

    val currentPrice: String,

    val fullDayFee: String,

    val fluctuationRate: String,

    val faceValue: String,

    val marketCap: String,

    val listedSharesNumber: String,

    val foreignerRatio: String,

    val tradingVolume: String,

    val per: String,

    val roe: String,

    val discussionRoom: String

)