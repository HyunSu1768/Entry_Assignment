package com.entry.persistence.stock.repository

import com.entry.persistence.stock.entity.StockJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository: JpaRepository<StockJpaEntity, String> {
}