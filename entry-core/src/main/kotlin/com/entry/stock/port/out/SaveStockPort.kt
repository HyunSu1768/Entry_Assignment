package com.entry.stock.port.out

import com.entry.stock.model.Stock

interface SaveStockPort {
    fun saveStock(stock: Stock)
}