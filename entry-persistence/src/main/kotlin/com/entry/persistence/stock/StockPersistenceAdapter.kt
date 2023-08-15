package com.entry.persistence.stock

import com.entry.common.PersistenceAdapter
import com.entry.common.error.BusinessException
import com.entry.common.error.ErrorCode
import com.entry.persistence.stock.mapper.StockMapper
import com.entry.persistence.stock.repository.StockRepository
import com.entry.stock.dto.response.StockListResponse
import com.entry.stock.dto.response.StockResponse
import com.entry.stock.model.Stock
import com.entry.stock.port.out.LoadStockListPort
import com.entry.stock.port.out.LoadStockPort
import com.entry.stock.port.out.SaveStockPort
import kotlin.streams.toList

@PersistenceAdapter
class StockPersistenceAdapter(
    val stockRepository: StockRepository,
    val stockMapper: StockMapper
): SaveStockPort, LoadStockListPort, LoadStockPort{

    override fun saveStock(stock: Stock) {

        stockRepository.save(
            stockMapper.toEntity(
                stock
            )
        )
    }

    override fun loadStockList(): StockListResponse {

        val stockResponseList =
            stockRepository.findAll().map { StockResponse.of(stockMapper.toDomain(it)) }.toList()

        return StockListResponse(stockResponseList)
    }

    override fun loadStock(stockId: String): Stock =
        stockMapper.toDomain(stockRepository.findById(stockId). orElseThrow{ BusinessException(ErrorCode.STOCK_NOT_FOUND)})
}