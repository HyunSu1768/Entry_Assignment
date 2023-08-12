package com.entry.stock

import com.entry.common.WebAdapter
import com.entry.stock.port.out.SaveStockPort
import com.entry.stock.port.out.StockSaveOrUpdatePort
import com.entry.thirdparty.stock.StockAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/stock")
@RestController
@WebAdapter
class StockWebAdapter(
    val stockSaveOrUpdatePort: StockSaveOrUpdatePort
) {

    // 테스트 용도
    @PostMapping("/download")
    fun downloadStock(){
        stockSaveOrUpdatePort.saveOrUpdate()
    }

}