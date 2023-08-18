package com.entry.persistence.stock.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tbl_stock")
data class StockJpaEntity(

    @Id
    @Column(length = 10)
    val id: String?,

    @Column(name = "stock_name", nullable = false, length = 100)
    val stockName: String,

    @Column(name = "stock_name", nullable = false, length = 100)
    val currentPrice: String,

    @Column(name = "full_day_fee", nullable = false, length = 100)
    val fullDayFee: String,

    @Column(name = "fluctuation_rate", nullable = false, length = 100)
    val fluctuationRate: String,

    @Column(name = "face_value", nullable = false, length = 100)
    val faceValue: String,

    @Column(name = "market_cap", nullable = false, length = 100)
    val marketCap: String,

    @Column(name = "listed_shares_number", nullable = false, length = 100)
    val listedSharesNumber: String,

    @Column(name = "foreigner_ratio", nullable = false, length = 100)
    val foreignerRatio: String,

    @Column(name = "trading_volume", nullable = false, length = 100)
    val tradingVolume: String,

    @Column(name = "per", nullable = false, length = 100)
    val per: String,

    @Column(name = "roe", nullable = false, length = 100)
    val roe: String,

    @Column(name = "discussion_room", nullable = false, length = 100)
    val discussionRoom: String

)