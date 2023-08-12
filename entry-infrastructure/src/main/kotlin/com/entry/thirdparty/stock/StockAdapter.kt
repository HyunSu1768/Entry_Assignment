package com.entry.thirdparty.stock

import com.entry.persistence.stock.entity.StockJpaEntity
import com.entry.stock.model.Stock
import com.entry.stock.port.out.SaveStockPort
import com.entry.stock.port.out.StockSaveOrUpdatePort
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Component

@Component
class StockAdapter(
    val saveStockPort: SaveStockPort
): StockSaveOrUpdatePort {
    override fun saveOrUpdate() {

        val stockList:String = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1"
        val conn = Jsoup.connect(stockList)

        val document = conn.get()
        getStockList(document)

    }

    private fun getStockList(document: Document) {
        val stockTableBody: Elements = document.select("table.type_2 tbody tr")

        for(element: Element in stockTableBody){
            if(element.attr("onmouseover").isEmpty()){
                continue
            }

            var number: String? = null
            val datas: MutableList<String> = ArrayList()

            for (td: Element in element.select("td")){
                var text: String
                if(td.select(".center a").attr("href").isEmpty()){
                    text = td.text()
                }
                else{
                    text = "https://finance.naver.com"+td.select(".center a").attr("href")
                    val href = td.select(".center a").attr("href")
                    val regex = Regex("\\d+") // 연속적으로 나타나는 숫자를 찾음
                    number = regex.find(href)?.value
                }
                datas.add(text)
            }
            val stock = Stock(
                id = number,
                stockName = datas[1],
                currentPrice = datas[2],
                fullDayFee =  datas[3],
                fluctuationRate = datas[4],
                faceValue = datas[5],
                marketCap = datas[6],
                listedSharesNumber = datas[7],
                foreignerRatio = datas[8],
                tradingVolume = datas[9],
                per = datas[10],
                roe = datas[11],
                discussionRoom =  datas[12]
            )
            saveStockPort.saveStock(stock)
        }
    }
}