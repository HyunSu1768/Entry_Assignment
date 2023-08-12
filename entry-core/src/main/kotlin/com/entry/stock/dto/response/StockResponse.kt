package com.entry.stock.dto.response

import com.entry.stock.model.Stock

data class StockResponse (
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

){

    companion object{
        fun of(stock: Stock): StockResponse{
            return StockResponse(
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

}