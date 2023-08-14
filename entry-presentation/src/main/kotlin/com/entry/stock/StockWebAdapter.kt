package com.entry.stock

import com.entry.common.WebAdapter
import com.entry.feed.port.`in`.LoadFeedListUseCase
import com.entry.stock.port.`in`.LoadStockLiseUseCase
import com.entry.stock.port.`in`.SaveOrUpdateStockUseCase
import com.entry.stock.port.out.SaveOrUpdateStockPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/stock")
@RestController
@WebAdapter
class StockWebAdapter(
    val saveOrUpdateStockUseCase: SaveOrUpdateStockUseCase,
    val loadStockListUseCase: LoadStockLiseUseCase
) {

    // 테스트 용도
    @PostMapping("/download")
    fun downloadStock() {
        saveOrUpdateStockUseCase.saveOrUpdate()
    }

    @GetMapping("/list")
    fun findAllStock() = loadStockListUseCase.loadStockList()
}