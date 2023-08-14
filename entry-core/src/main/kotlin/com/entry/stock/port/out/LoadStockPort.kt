package com.entry.stock.port.out

import com.entry.stock.model.Stock

interface LoadStockPort {

    fun loadStock(stockId: String): Stock
}