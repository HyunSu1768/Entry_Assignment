package com.entry.persistence.stock.mapper

import com.entry.persistence.stock.entity.StockJpaEntity
import com.entry.stock.model.Stock
import org.springframework.stereotype.Component

@Component
class StockMapper {

    fun toEntity(stock: Stock): StockJpaEntity{
        return StockJpaEntity(
            id = stock.id,
            stockName=stock.stockName,
            currentPrice=stock.currentPrice,
            fullDayFee=stock.fullDayFee,
            fluctuationRate=stock.fluctuationRate,
            faceValue=stock.faceValue,
            marketCap=stock.marketCap,
            listedSharesNumber=stock.listedSharesNumber,
            foreignerRatio=stock.foreignerRatio,
            tradingVolume=stock.tradingVolume,
            per=stock.per,
            roe=stock.roe,
            discussionRoom=stock.discussionRoom
        )
    }

}