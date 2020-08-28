package com.casestudy.stockexchange.Repositories;

import com.casestudy.stockexchange.Entity.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {
    public Optional<StockExchange> findByName(String name);
}
