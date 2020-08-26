package com.casestudy.stockexchange.Repositories;

import com.casestudy.stockexchange.Entity.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {
}
