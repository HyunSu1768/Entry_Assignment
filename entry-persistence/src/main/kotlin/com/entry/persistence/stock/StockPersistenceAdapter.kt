package com.entry.persistence.stock

import com.entry.common.PersistenceAdapter
import com.entry.persistence.stock.mapper.StockMapper
import com.entry.persistence.stock.repository.StockRepository
import com.entry.stock.model.Stock
import com.entry.stock.port.out.SaveStockPort

@PersistenceAdapter
class StockPersistenceAdapter(
    val stockRepository: StockRepository,
    val stockMapper: StockMapper
): SaveStockPort{
    override fun saveStock(stock: Stock) {
        stockRepository.save(
            stockMapper.toEntity(
                stock
            )
        )
    }
}