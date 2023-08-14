package com.entry.stock.service

import com.entry.common.UseCase
import com.entry.stock.port.`in`.SaveOrUpdateStockUseCase
import com.entry.stock.port.out.SaveOrUpdateStockPort

@UseCase
class SaveOrUpdateService(
    private val saveOrUpdateStockPort: SaveOrUpdateStockPort
): SaveOrUpdateStockUseCase {

    override fun saveOrUpdate() {
        saveOrUpdateStockPort.saveOrUpdate()
    }
}