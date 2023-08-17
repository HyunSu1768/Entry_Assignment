package com.entry.stock

import com.entry.common.WebAdapter
import com.entry.stock.dto.response.StockListResponse
import com.entry.stock.port.`in`.LoadStockListUseCase
import com.entry.stock.port.`in`.SaveOrUpdateStockUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/stock")
@RestController
@WebAdapter
class StockWebAdapter(
    val saveOrUpdateStockUseCase: SaveOrUpdateStockUseCase,
    val loadStockListUseCase: LoadStockListUseCase
) {

    // 테스트 용도
    @PostMapping("/download")
    fun downloadStock() {
        saveOrUpdateStockUseCase.saveOrUpdate()
    }

    @GetMapping("/list")
    fun findAllStock(): StockListResponse = loadStockListUseCase.loadStockList()
}