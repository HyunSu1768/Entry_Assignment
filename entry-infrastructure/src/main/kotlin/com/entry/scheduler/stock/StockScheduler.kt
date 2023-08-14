package com.entry.scheduler.stock

import com.entry.stock.port.`in`.SaveOrUpdateStockUseCase
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class StockScheduler(
    private val saveOrUpdateStockUseCase: SaveOrUpdateStockUseCase
) {

    /*
    5분마다 실행
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    fun saveOrUpdateStock(){
        saveOrUpdateStockUseCase.saveOrUpdate()
    }

}